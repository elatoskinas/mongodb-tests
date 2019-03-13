package mapping;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("Publication")
public class Publication {
    @Id
    private int publicationId;
    private String title;
    private String issue;
    private String pages;
    private int year;

    public Publication(int publicationId, String title, String issue, String pages, int year) {
        this.publicationId = publicationId;
        this.title = title;
        this.issue = issue;
        this.pages = pages;
        this.year = year;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
