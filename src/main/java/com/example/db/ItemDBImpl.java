package com.example.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.vo.Item;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.conversions.Bson;

public class ItemDBImpl implements ItemDB {
    private final String url = "mongodb://id206:pw206@1.234.5.158:37017/db206";

    private MongoCollection<Document> collection = null;
    private MongoCollection<Document> seqCollection = null;

    // DB 접속
    public ItemDBImpl() {
        MongoClient client = MongoClients.create(this.url);

        MongoDatabase db = client.getDatabase("db206");

        this.seqCollection = db.getCollection("sequence");
        this.collection = db.getCollection("item2");
    }

    // 추가하기
    @Override
    public int insertItem(Item item) {
        try {
            // 시퀀스 값 가져오기
            Bson filter = Filters.eq("_id", "SEQ_ITEM2_NO");
            Bson update = Updates.inc("seq", 1);
            Document doc = this.seqCollection.findOneAndUpdate(filter, update);
            long seq = doc.getLong("seq");
            System.out.println("seq --->" + seq);

            Document doc1 = new Document();
            doc1.append("_id", seq);
            doc1.append("name", item.getName());
            doc1.append("price", item.getPrice());
            doc1.append("quantity", item.getQuantity());
            doc1.append("content", item.getContent());

            InsertOneResult result = this.collection.insertOne(doc1);
            System.out.println("추가 결과: " + result);
            // AcknowledgedInsertOneResult{insertedId=BsonInt64{value=1}}

            if (result.getInsertedId().asInt64().getValue() == seq) {
                return 1;
            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    // 삭제하기
    @Override
    public int deleteItem(long code) throws Exception {

        // eq: static 메소드(객체에 .을 찍어서 확인)
        Bson filter = Filters.eq("_id", code);

        DeleteResult result = collection.deleteOne(filter);

        if (result.getDeletedCount() == 1L) {
            return 1;
        }
        return 0;
    }

    // 수정하기
    @Override
    public int updateItem(Item item) throws Exception {

        Bson filter = Filters.eq("_id", item.getNo());

        Bson bson1 = Updates.set("name", item.getName());
        Bson bson2 = Updates.set("price", item.getPrice());
        Bson bson3 = Updates.set("quantity", item.getQuantity());

        Bson update = Updates.combine(bson1, bson2, bson3);

        UpdateResult result = collection.updateOne(filter, update);

        if (result.getModifiedCount() == 1L) {
            return 1;
        }
        return 0;
    }

    // 목록조회
    @Override
    public List<Item> selectListItem() throws Exception {
        // 일부 데이터만 가져오기 projection
        // 제외시킴(exclude), 포함시킴(include)
        Bson projection = Projections.exclude("name");

        FindIterable<Document> rows = collection.find()
                .projection(projection)
                .sort(Filters.eq("_id", 1));

        // 타입 변환
        List<Item> list = new ArrayList<Item>();
        for (Document tmp : rows) {
            Item sendItem = new Item(
                    tmp.getLong("_id"),
                    null,
                    tmp.getLong("price"),
                    tmp.getLong("quantity"),
                    tmp.getString("content"));
            list.add(sendItem);
        }

        return list;
    }

    // 페이지 조회
    @Override
    public List<Item> selectListPageItem(int page) {
        try {
            // 1 오름차순, -1 내림차순
            Bson sort = Filters.eq("_id", 1);

            // 페이지 1 => 0, 10
            // 페이지 2 => 10, 10
            // 페이지 3 => 20, 10
            int skip = (page - 1) * 10;
            int limit = 10;

            FindIterable<Document> rows = collection.find()
                    .sort(sort)
                    .skip(skip)
                    .limit(limit);

            // 타입 변환
            List<Item> list = new ArrayList<Item>();
            for (Document tmp : rows) {
                Item sendItem = new Item(
                        tmp.getLong("_id"),
                        tmp.getString("name"),
                        tmp.getLong("price"),
                        tmp.getLong("quantity"),
                        tmp.getString("content"));
                list.add(sendItem);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // 1개 조회
    @Override
    public Item selectOneItem(long code) {
        try {
            Bson filter = Filters.eq("_id", code);

            Item item = new Item();

            FindIterable<Document> rows = collection.find(filter);

            for (Document tmp : rows) {
                item.setNo(tmp.getLong("_id"));
                item.setName(tmp.getString("name"));
                item.setPrice(tmp.getLong("price"));
                item.setQuantity(tmp.getLong("quantity"));
            }

            return item;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 1개 조회(Map)
    @Override
    public Map<String, Object> selectOneMapItem(long code) {
        try {
            Bson filter = Filters.eq("_id", code);

            Map<String, Object> map = new HashMap<>();
            // map.put("_id", 1L);

            // Iterable 이 붙은건 반복문을 사용해야함.
            FindIterable<Document> rows = collection.find(filter);

            for (Document tmp : rows) {
                // map 키(변수)를 마음대로 해서 추가함.
                map.put("ID", tmp.getLong("_id"));
                map.put("NAME", tmp.getString("name"));
                map.put("PRICE", tmp.getLong("price"));
                map.put("QTY", tmp.getLong("quantity"));
            }

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
