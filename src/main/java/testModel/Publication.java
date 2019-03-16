package testModel;

import org.mongodb.morphia.annotations.*;

import static org.mongodb.morphia.utils.IndexType.TEXT;

@Entity
@Indexes(@Index(fields = @Field(value = "$**", type = TEXT)))
public class Publication {
    @Id
    private int publicationId;
    private String title;
    private String issue;
    private String pages;
    private int year;

    @Override
    public String toString() {
        return "Publication{" +
                "publicationId=" + publicationId +
                ", title='" + title + '\'' +
                ", issue='" + issue + '\'' +
                ", pages='" + pages + '\'' +
                ", year=" + year +
                '}';
    }

    public Publication() {}

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
