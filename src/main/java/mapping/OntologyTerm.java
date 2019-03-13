package mapping;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("OntologyTerm")
public class OntologyTerm {
    @Id
    private String identifier;

    private String name;
    private String description;
    private String namepsace;
    private boolean obsolete;

    public OntologyTerm() {

    }

    public OntologyTerm(String identifier, String name, String description, String namepsace, boolean obsolete) {
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.namepsace = namepsace;
        this.obsolete = obsolete;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNamepsace() {
        return namepsace;
    }

    public void setNamepsace(String namepsace) {
        this.namepsace = namepsace;
    }

    public boolean isObsolete() {
        return obsolete;
    }

    public void setObsolete(boolean obsolete) {
        this.obsolete = obsolete;
    }
}
