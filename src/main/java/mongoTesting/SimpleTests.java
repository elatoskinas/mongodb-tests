package mongoTesting;

import abstractModel.AbstractionImpl;
import abstractModel.AbstractionImpl2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleTests {
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

    /**.
     * Populatees a MongoCollection (Testing purposes)
     * @param collection - collection to populate
     */
    private static void testPopulate(MongoCollection collection)
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

    /**.
     * Adds a single object to a specified collection
     * @param collection - MongoCollection to add to
     * @param object - Objct to add
     */
    private static void addToCollection(MongoCollection collection, Object object)
    {
        collection.insertOne(convertToDocument(object));
    }

    /**.
     * Maps object to Document by converting it to JSON
     * @param object - object to map
     * @return MongoDB Document, which represents the specified object
     */
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
