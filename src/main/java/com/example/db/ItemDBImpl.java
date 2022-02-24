package com.example.db;

import java.util.List;
import java.util.Map;

import com.example.vo.Item;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;

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

    @Override
    public int deleteItem(Item item) {
        try {
            Bson bson = Filters.eq("_id", "SEQ_ITEM2_NO");
            FindIterable<Document> seq = seqCollection.find(bson);
            Bson bson1 = Filters.eq("_id", seq);

            DeleteResult result = collection.deleteOne(bson1);

            System.out.println("이게 맞나..." + result);

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public int updateItem(Item item) {

        return 0;
    }

    @Override
    public List<Item> selectListItem() {

        return null;
    }

    @Override
    public List<Item> selectListPageItem(int page) {

        return null;
    }

    @Override
    public Item selectOneItem(long code) {

        return null;
    }

    @Override
    public Map<String, Object> selectOneMapItem(long code) {

        return null;
    }

}
