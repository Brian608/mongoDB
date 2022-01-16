package org.feather.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @program: mongoDB_java
 * @description:
 * @author: 杜雪松(feather)
 * @since: 2022-01-16 08:54
 **/
public class DocumentFindTest {
    public static void main(String[] args) {
        MongoClient mongoClient=new MongoClient("127.0.0.1",27017);
        MongoDatabase database=mongoClient.getDatabase("resume");
        MongoCollection<Document> collection = database.getCollection("resume");
        //根据薪资降序
        Document sortDocument=new Document();
        sortDocument.append("expectSalary",-1);
        FindIterable<Document> documents = collection.find().sort(sortDocument);
        for (Document  document:
            documents ) {
            System.out.println(document);
        }
        mongoClient.close();

    }
}
