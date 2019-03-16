package mongoTesting;

import abstractModel.Abstraction;
import abstractModel.AbstractionImpl;
import abstractModel.AbstractionImpl2;
import com.mongodb.AggregationOptions;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.aggregation.AggregationPipeline;
import org.mongodb.morphia.aggregation.Projection;
import org.mongodb.morphia.query.Meta;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.Sort;
import testModel.Author;
import testModel.OntologyTerm;
import testModel.Publication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class QueyingTests {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost");
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(mongoClient, "testdb");

        // Simple Project Query
        Query<Publication> publicationExample1 =
                datastore.createQuery(Publication.class).project("pages", true).project("year", true);

        // Simple Equal Query
        Query<Publication> publicationExample2 =
                datastore.createQuery(Publication.class).field("title").equal("Publication 1");

        // Membership Query
        ArrayList<String> titleList = new ArrayList<String>();
        titleList.add("Publication 1");
        titleList.add("Publication 5");

        Query<Publication> publicationMultiValue =
                datastore.createQuery(Publication.class).field("title").hasAnyOf(titleList);

        // Element Lookup Query
        Query<Publication> publicationLookupQuery =
                datastore.createQuery(Publication.class).search("9");

        // Object Comparison Query
        AggregationPipeline aggregationPipeline = datastore.createAggregation(Publication.class)
                .project(Projection.projection("title"))
                .lookup("Author", "title", "initials", "title-initials")
                .unwind("title-initials");

        AggregationOptions aggregationOptions = AggregationOptions.builder().outputMode(AggregationOptions.OutputMode.CURSOR).build();
        Iterator<Publication> iterator = aggregationPipeline.aggregate(Publication.class, aggregationOptions);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Null Values
        Query<Publication> publicationNullQuery =
                datastore.createQuery(Publication.class)
                .project("title", true)
                .project("issue", true)
                .field("issue").notEqual(null);

//        System.out.println(publicationNullQuery.asList());

        // Sorting Query
        Sort[] sorts = new Sort[] { Sort.descending("title"), Sort.ascending("year") };

        Query<Publication> publicationSort =
                datastore.createQuery(Publication.class).project("title", true).order(sorts);
    }
}
