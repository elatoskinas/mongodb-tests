package mongoTesting;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import testModel.*;

import java.util.ArrayList;

public class MappingTests {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost");
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(mongoClient, "testdb");

        // Save some OntologyTerms to the database
        OntologyTerm term1 = new OntologyTerm("term1", "Term 1", "Term 1 Description",
                "namespace", false);
        datastore.save(term1);

        OntologyTerm term2 = new OntologyTerm("term2", "Term 2", "Term 2 Description",
                "namespace", false);
        datastore.save(term2);

        // Save an OntologyRelation to the database
        OntologyRelation relation = new OntologyRelation(term1, term2, "relationship", true, false);
        datastore.save(relation);

        // Construct & save a list of Publications
        ArrayList<Publication> publications = new ArrayList<Publication>();

        Publication publication1 = new Publication(52, "Publication", "3", "100", 2019);
        Publication publication2 = new Publication(25, "Publication 2", "5", "125", 2019);
        Publication publication3 = new Publication(50, "Publication 3", "7", "50", 2019);

        publications.add(publication1);
        publications.add(publication2);
        publications.add(publication3);

        datastore.save(publications);

        // Construct & save an Author object
        Author author = new Author("John", "Doe", "John Doe", "jdie", publications);
        datastore.save(author);

        // Construct & save an OntologyEvidence object
        OntologyAnnotationEvidenceCode code = new OntologyAnnotationEvidenceCode("code", "name", "url");
        OntologyEvidence ontologyEvidence = new OntologyEvidence(code);

        datastore.save(ontologyEvidence);

        OntologyTerm term3 = new OntologyTerm("term3", "Term 3", "Term 3 Description", "namespace", false);
        datastore.save(term3);

        // --- Simple query examples ---
        // Query to find OntologyTerm with id equal to term3
        Query<OntologyTerm> query = datastore.createQuery(OntologyTerm.class).field("_id").equal("term3");
//        datastore.findAndDelete(query);

        // Update query to update OntologyTerm descrption to "Term 3 Description Updated!"
        UpdateOperations<OntologyTerm> update = datastore.createUpdateOperations(OntologyTerm.class).set("description",
                "Term 3 Description Updated!");

        // Execute update query on OntologyTerm with _id equal to term3
        datastore.update(query, update);

        // Remove description field query
        UpdateOperations<OntologyTerm> update2 = datastore.createUpdateOperations(OntologyTerm.class).unset("description");
        datastore.update(query, update2);
    }
}
