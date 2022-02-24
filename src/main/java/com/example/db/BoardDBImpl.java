package com.example.db;

import java.util.ArrayList;
import java.util.List;

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

// 구현
// 파일명: BoardDBImpl.java
public class BoardDBImpl implements BoardDB {
    private final String url = "mongodb://id206:pw206@1.234.5.158:37017/db206";

    private MongoCollection<Document> collection = null;

    // DB 연결
    // 생성자에서 외부에서 객체 생성 시점에 DB연결하고 컬렉션도 선택
    public BoardDBImpl() {
        MongoClient client = MongoClients.create(this.url);

        MongoDatabase db = client.getDatabase("db206");

        this.collection = db.getCollection("board2");
    }

    // 추가하기
    @Override
    public int insertBoard(Board board) {
        try {
            // 2. Document
            // 추가하기: set, add, append
            Document doc = new Document();
            doc.append("_id", board.getNo());
            doc.append("title", board.getTitle());
            doc.append("content", board.getContent());
            doc.append("writer", board.getWriter());
            doc.append("hit", board.getHit());

            // 1. 컬렉션에 데이터를 추가하기(Document가 필요!!)
            // result에 추가했던 _id의 값이 리턴됨
            InsertOneResult result = this.collection.insertOne(doc);
            System.out.println("결과: " + result);

            // String aa="aa"; => if(aa.equals("aa")){}
            // long aa=1L; => if(aa == 2){}

            if (result.getInsertedId()
                    .asInt64().getValue() == board.getNo()) {
                return 1; // 성공
            }

            return 0; // 실패
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    // 삭제하기
    @Override
    public int deleteBoard(Board board) {
        try {
            // 2. bson
            Bson bson = Filters.eq("_id", board.getNo());

            // 1. 삭제(Bson)
            DeleteResult result = this.collection.deleteOne(bson);

            if (result.getDeletedCount() == 1L) {
                return 1;
            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    // 수정하기
    @Override
    public int updateBoard(Board board) {
        try {
            Bson bson = Filters.eq("_id", board.getNo());

            Bson bson1 = Updates.set("title", board.getTitle());
            Bson bson2 = Updates.set("content", board.getContent());
            Bson bson3 = Updates.set("writer", board.getWriter());

            Bson bson4 = Updates.combine(bson1, bson2, bson3);

            // Bson(조건), Bson(변경값)
            UpdateResult result = collection.updateOne(bson, bson4);
            if (result.getModifiedCount() == 1L) {
                return 1;
            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    // 1개 조회하기
    @Override
    public Board selectOneBoard(Board board) {
        try {
            Bson bson = Filters.eq("_id", board.getNo());

            // List<String> <= "aaa", "bbb", "ccc"
            FindIterable<Document> rows = collection.find(bson);

            // rows에 있는걸 하나씩 tmp에 넣어줌
            for (Document tmp : rows) { // 1번만 반복
                return new Board(
                        tmp.getLong("_id"),
                        tmp.getString("title"),
                        tmp.getString("content"),
                        tmp.getString("writer"),
                        tmp.getInteger("hit"));
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // 목록 조회하기
    @Override
    public List<Board> selectListBoard() {
        try {
            FindIterable<Document> rows = collection.find()
                    .sort(Filters.eq("_id", 1));

            // Board를 n개 보관할 수 있는 list 변수
            // 가변길이 배열 [{}, {}, {}]
            List<Board> list = new ArrayList<Board>(); // list ==> null

            for (Document tmp : rows) {
                Board sendBoard = new Board(
                        tmp.getLong("_id"),
                        tmp.getString("title"),
                        tmp.getString("content"),
                        tmp.getString("writer"),
                        tmp.getInteger("hit"));
                list.add(sendBoard);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
