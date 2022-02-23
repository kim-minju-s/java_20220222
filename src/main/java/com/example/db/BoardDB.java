package com.example.db;

import java.util.ArrayList;

import com.example.vo.Board;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.conversions.Bson;

public class BoardDB {

    private MongoCollection<Document> collection = null;

    public BoardDB() {
        // db연결하기
        String url = "mongodb://id206:pw206@1.234.5.158:37017/db206";

        MongoClient client = MongoClients.create(url);

        MongoDatabase db = client.getDatabase("db206");

        // 선택한 컬렉션을 collection 변수에 넣기
        this.collection = db.getCollection("board2");
    }

    // 게시글 추가하기
    public int insertData(Board board) {
        try {

            Document doc = new Document();
            doc.append("_id", board.getNo());
            doc.append("title", board.getTitle());
            doc.append("content", board.getContent());
            doc.append("writer", board.getWriter());
            doc.append("hit", board.getHit());

            InsertOneResult result = this.collection.insertOne(doc);

            System.out.println("추가 결과: " + result);
            // AcknowledgedInsertOneResult{insertedId=BsonInt64{value=1}}

            if (result.getInsertedId()
                    .asInt64()
                    .getValue() == board.getNo()) {
                return 1;
            }
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 게시글 삭제하기
    public int deleteData(Board board) {
        try {

            Bson bson = Filters.eq("_id", board.getNo());

            DeleteResult result = this.collection.deleteOne(bson);
            System.out.println(result.toString());
            // AcknowledgedDeleteResult{deletedCount=1}
            if (result.getDeletedCount() == 1L) {
                return 1;
            }
            return 0;

        } catch (Exception e) {
            e.printStackTrace(); // 오류출력
            return -1;
        }
    }

    // 게시글 수정하기
    public int updateData(Board board) {
        try {

            Bson bson = Filters.eq("_id", board.getNo());

            Bson bson1 = Updates.set("title", board.getTitle());
            Bson bson2 = Updates.set("writer", board.getWriter());
            Bson bson3 = Updates.set("content", board.getContent());

            Bson bson4 = Updates.combine(bson1, bson2, bson3);

            UpdateResult result = this.collection.updateOne(bson, bson4);
            System.out.println("수정 결과: " + result.toString());
            // AcknowledgedUpdateResult{matchedCount=1, modifiedCount=1, upsertedId=null}

            if (result.getModifiedCount() == 1) {
                return 1;
            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 게시글 1개 조회하기
    public Board selectOneData(Board board) {
        try {

            Bson bson = Filters.eq("_id", board.getNo());

            FindIterable<Document> docs = this.collection.find(bson);
            Board sendBoard = new Board();
            for (Document tmp : docs) {
                sendBoard.setNo(tmp.getLong("_id"));
                sendBoard.setTitle(tmp.getString("title"));
                sendBoard.setContent(tmp.getString("content"));
                sendBoard.setWriter(tmp.getString("writer"));
                sendBoard.setHit(tmp.getInteger("hit"));

                // System.out.println("조회 결과: " + tmp.getLong("_id"));
                // System.out.println("1개 조회" + tmp);
            }
            return sendBoard;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 게시글 목록 조회
    public ArrayList<Board> selectListData() {
        try {

            FindIterable<Document> docs = this.collection
                    .find().sort(Filters.eq("_id", 1));

            ArrayList<Board> list = new ArrayList<Board>();

            for (Document tmp : docs) {
                Board sendBoard = new Board();
                sendBoard.setNo(tmp.getLong("_id"));
                sendBoard.setTitle(tmp.getString("title"));
                sendBoard.setContent(tmp.getString("content"));
                sendBoard.setWriter(tmp.getString("writer"));
                sendBoard.setHit(tmp.getInteger("hit"));

                list.add(sendBoard);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
