package mapping;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

@Entity("OntologyRelation")
public class OntologyRelation {
    @Reference(idOnly = true)
    private OntologyTerm parentTerm;

    @Reference(idOnly = true)
    private OntologyTerm childTerm;

    private String relationship;
    private boolean direct;
    private boolean redundant;

    public OntologyRelation(OntologyTerm parentTerm, OntologyTerm childTerm, String relationship, boolean direct, boolean redundant) {
        this.parentTerm = parentTerm;
        this.childTerm = childTerm;
        this.relationship = relationship;
        this.direct = direct;
        this.redundant = redundant;
    }

    public OntologyTerm getParentTerm() {
        return parentTerm;
    }

    public void setParentTerm(OntologyTerm parentTerm) {
        this.parentTerm = parentTerm;
    }

    public OntologyTerm getChildTerm() {
        return childTerm;
    }

    public void setChildTerm(OntologyTerm childTerm) {
        this.childTerm = childTerm;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    public boolean isRedundant() {
        return redundant;
    }

    public void setRedundant(boolean redundant) {
        this.redundant = redundant;
    }
}
