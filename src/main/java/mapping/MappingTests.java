package mapping;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateOpsImpl;

import java.util.ArrayList;

public class MappingTests {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost");

        Morphia morphia = new Morphia();

        Datastore datastore = morphia.createDatastore(mongoClient, "testdb");

        OntologyTerm term1 = new OntologyTerm("term1", "Term 1", "Term 1 Description", "namespace", false);
        datastore.save(term1);

        OntologyTerm term2 = new OntologyTerm("term2", "Term 2", "Term 2 Description", "namespace", false);
        datastore.save(term2);

        OntologyRelation relation = new OntologyRelation(term1, term2, "relationship", true, false);
        datastore.save(relation);

        ArrayList<Publication> publications = new ArrayList<Publication>();

        Publication publication1 = new Publication(52, "Publication", "3", "100", 2019);
        Publication publication2 = new Publication(25, "Publication 2", "5", "125", 2019);
        Publication publication3 = new Publication(50, "Publication 3", "7", "50", 2019);

        publications.add(publication1);
        publications.add(publication2);
        publications.add(publication3);

        datastore.save(publications);

        Author author = new Author("John", "Doe", "John Doe", "jdie", publications);
        datastore.save(author);

        OntologyAnnotationEvidenceCode code = new OntologyAnnotationEvidenceCode("code", "name", "url");
        OntologyEvidence ontologyEvidence = new OntologyEvidence(code);

        datastore.save(ontologyEvidence);

        OntologyTerm term3 = new OntologyTerm("term3", "Term 3", "Term 3 Description", "namespace", false);
        datastore.save(term3);

        Query<OntologyTerm> query = datastore.createQuery(OntologyTerm.class).field("_id").equal("term3");
//        datastore.findAndDelete(query);

        UpdateOperations<OntologyTerm> update = datastore.createUpdateOperations(OntologyTerm.class).set("description", "Term 3 Description Updated!");
        datastore.update(query, update);

        UpdateOperations<OntologyTerm> update2 = datastore.createUpdateOperations(OntologyTerm.class).unset("description");
        datastore.update(query, update2);
    }
}
