package mapping;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;

@Entity("Author")
public class Author {
    private String firstName;
    private String lastName;
    private String name;
    private String initials;

    @Reference(idOnly = true)
    private ArrayList<Publication> publications;

    public Author(String firstName, String lastName, String name, String initials, ArrayList<Publication> publications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.initials = initials;
        this.publications = publications;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }
}
