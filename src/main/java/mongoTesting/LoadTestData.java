package mongoTesting;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import testModel.Author;
import testModel.OntologyRelation;
import testModel.Publication;

import java.util.ArrayList;

public class LoadTestData {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost");
        Morphia morphia = new Morphia();

        // Drop testdb to re-load fresh data
        mongoClient.dropDatabase("testdb");

        // We will store our collections in the "testdb" database instance
        Datastore datastore = morphia.createDatastore(mongoClient, "testdb");

        // Create new list of Publication objects
        ArrayList<Publication> publications = new ArrayList<Publication>();

        // Populate the list
        for (int i = 0; i < 100; ++i) {
            String publicationTitle = "Publication " + (i + 1);
            String publicationIssue = "Issue " + (1 + i / 10);
            String publicationPages = (i+1)*20 + "";
            int year = 2015 + (i / 25);
            //publicationIssue = null; // uncomment to test null queries

            Publication publication = new Publication(i, publicationTitle, publicationIssue, publicationPages, year);
            publications.add(publication);
        }

        // Add one more publication for testing
        publications.add(new Publication(100, "JD", "Publication100", "200", 2016));

        // Add a few authors
        Author author1 = new Author("John", "Doe", "John Doe", "JD", new ArrayList<Publication>());
        Author author2 = new Author("John", "Smith", "John Smith", "JS", new ArrayList<Publication>());
        Author author3 = new Author("Jane", "Doe", "Jane Doe", "JD", new ArrayList<Publication>());

        // Add publications to the first Author
        for (int i = 0; i < 25; ++i) {
            author1.getPublications().add(publications.get(i));
        }

        // Save data
        datastore.save(publications);
        datastore.save(author1);
        datastore.save(author2);
        datastore.save(author3);
        datastore.ensureIndexes();
    }
}
