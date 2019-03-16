package testModel;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class OntologyEvidence {
    OntologyAnnotationEvidenceCode code;

    public OntologyEvidence(OntologyAnnotationEvidenceCode code) {
        this.code = code;
    }

    public OntologyAnnotationEvidenceCode getCode() {
        return code;
    }

    public void setCode(OntologyAnnotationEvidenceCode code) {
        this.code = code;
    }
}
