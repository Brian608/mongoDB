package org.feather.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @program: mongoDB_java
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-01-15 20:32
 **/
public class DocumentInsert {
    public static void main(String[] args) {
        MongoClient mongoClient=new MongoClient("127.0.0.1",27017);
        MongoDatabase database=mongoClient.getDatabase("resume");
        MongoCollection<Document> collection = database.getCollection("resume");
        Document document = Document.parse("{name:'张三',city:'北京',birthDay:new ISODate('1999-07-25'),expectSalary:24000,gender:1}");
        collection.insertOne(document);
        mongoClient.close();
    }

}
