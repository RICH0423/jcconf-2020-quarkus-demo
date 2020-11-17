package com.rich.quarkus.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserRepository {

    private static Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    @Inject
    MongoClient mongoClient;

    public List<User> getAll(){
        List<User> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                User user = new User();
                user.setId(document.getObjectId("_id").toString());
                user.setName(document.getString("name"));
                user.setAge(document.getInteger("age"));
                list.add(user);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void create(User user){
        Document document = new Document()
                .append("name", user.getName())
                .append("age", user.getAge());
        InsertOneResult result = getCollection().insertOne(document);
        LOGGER.info("inserted result: {}", result);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("demo").getCollection("user");
    }
}
