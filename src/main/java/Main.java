import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    private static String HOST_NAME = "localhost";
    private static String DATABASE_NAME = "testdb";
    private static String COLLECTION_NAME = "test";

    public static void main(String[] args)
    {
        MongoClient mongoClient = new MongoClient(HOST_NAME);
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection collection = database.getCollection(COLLECTION_NAME);
        testPopulate(collection);
    }

    public static void testPopulate(MongoCollection collection)
    {
        AbstractionImpl o1 = new AbstractionImpl(15, 25, "text");
        AbstractionImpl o2 = new AbstractionImpl(55, 40, "abc");
        AbstractionImpl o3 = new AbstractionImpl(88, 100, "www");
        AbstractionImpl2 a1 = new AbstractionImpl2(12, 44, "str", 4.5f, 2.3f);
        AbstractionImpl2 a2 = new AbstractionImpl2(55, 3, "zxc", 0.4f, 1.1f);

        ArrayList<Integer> a2_list = new ArrayList<Integer>();

        for (int i = 1; i <= 100; i += 2)
        {
            a2_list.add(i);
        }

        a2.setIntList1(a2_list);

        addToCollection(collection, o1);
        addToCollection(collection, o2);
        addToCollection(collection, o3);
        addToCollection(collection, a1);
        addToCollection(collection, a2);
    }

    public static void addToCollection(MongoCollection collection, Object object)
    {
        collection.insertOne(convertToDocument(object));
    }

    private static Document convertToDocument(Object object)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            String objectJson = objectMapper.writeValueAsString(object);
            return Document.parse(objectJson);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
