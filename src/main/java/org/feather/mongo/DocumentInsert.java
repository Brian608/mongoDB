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
        Document document = Document.parse("{name:'李四',city:'上海',birthDay:new ISODate('1998-09-25'),expectSalary:18000,gender:1}");
        collection.insertOne(document);
        mongoClient.close();
    }

}
