package com.example.db;

import java.util.ArrayList;

import com.example.vo.Member;
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

// 파일명: MemberDB.java
public class MemberDB {

    private MongoCollection<Document> collection = null;

    // 생성자
    // DB 연결시킴
    public MemberDB() {
        String url = "mongodb://id206:pw206@1.234.5.158:37017/db206";

        // 1. 접속하기 static으로 되어있음. 접속은 객체를 n개 생성 불가
        MongoClient client = MongoClients.create(url);

        // 2. db연결
        MongoDatabase db = client.getDatabase("db206");

        // 3. 컬렉션 선택(member2)
        this.collection = db.getCollection("member2");

    }

    // 메소드(데이터 추가 기능)
    public int insertData(Member member) {
        try {
            // 추가할 내용을 변수에 담기
            Document doc = new Document();
            doc.append("_id", member.getId());
            doc.append("name", member.getName());
            doc.append("role", member.getRole());
            doc.append("age", member.getAge());
            doc.append("regdate", member.getRegdate());

            InsertOneResult result = this.collection.insertOne(doc);
            // 결과: AcknowledgedInsertOneResult{insertedId=BsonString{value='ab'}}
            System.out.println("결과: " + result);

            if (result.getInsertedId()
                    .asString()
                    .getValue().equals(member.getId())) {
                return 1;
            }
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    // 메소드( 데이터 삭제 기능 )
    public int deleteData(Member member) {
        try {

            // 조건 만들기
            Bson bson = Filters.eq("_id", member.getId());

            // 삭제하기
            DeleteResult result = this.collection.deleteOne(bson);
            if (result.getDeletedCount() == 1L) {
                return 1;
            }
            return 0;

        } catch (Exception e) {
            e.printStackTrace(); // 오류출력
            return -1;
        }
    }

    // 메소드( 데이터 수정 기능 )
    public int updateData(Member member) {
        try {
            // 수정하고자 하는 아이디 조건
            Bson bson = Filters.eq("_id", member.getId());

            // 변경하고자 하는 내용
            Bson bson1 = Updates.set("name", member.getName());
            Bson bson2 = Updates.set("age", member.getAge());

            // 변경하고자 하는 내용이 여러개일 때 합침
            Bson bson3 = Updates.combine(bson1, bson2);

            UpdateResult result = this.collection.updateOne(bson, bson3);
            if (result.getModifiedCount() == 1L) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 메소드 (1개 조회)
    public Member selectOneData(Member member) {
        try {
            // Document -> Member

            // 조건(넣으면 조건에 해당하는 것만, 안넣으면 전체)
            Bson bson = Filters.eq("_id", member.getId());

            FindIterable<Document> docs = this.collection.find(bson);
            Member sendmember = new Member();
            for (Document tmp : docs) { // 1회 반복
                sendmember.setId(tmp.getString("_id"));
                sendmember.setName(tmp.getString("name"));
                sendmember.setAge(tmp.getInteger("age"));
                sendmember.setRole(tmp.getString("role"));
                sendmember.setRegdate(tmp.getString("regdate"));

                // System.out.println(tmp.getString("_id"));
                // System.out.println(tmp);
            }
            return sendmember;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 메소드( 여러개 조회 )
    public ArrayList<Member> selectListData() {
        try {

            // 전체 조회하기, 정렬을 _id 오름차순
            FindIterable<Document> docs = this.collection
                    .find().sort(Filters.eq("_id", 1));

            // 배열 압축시키기 : 클래스명<E> list = new 클래스명<E>();
            ArrayList<Member> list = new ArrayList<Member>();

            for (Document tmp : docs) {
                Member sendMember = new Member();
                sendMember.setId(tmp.getString("_id"));
                sendMember.setName(tmp.getString("name"));
                sendMember.setAge(tmp.getInteger("age"));
                sendMember.setRole(tmp.getString("role"));
                sendMember.setRegdate(tmp.getString("regdate"));

                list.add(sendMember); // 4번 수행
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
