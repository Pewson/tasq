package pl.sdacademy.tasq.test;

import org.hibernate.annotations.GenericGenerator;
import pl.sdacademy.tasq.DocType;
import pl.sdacademy.tasq.author.Author;
import pl.sdacademy.tasq.question.Question;

import javax.persistence.*;
import java.util.List;

@Entity(name="Test")
@Table(name="test")
public class Test {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @Column(name="title")
    private String title;

    @ManyToOne(fetch=FetchType.EAGER)
    private Author author;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Question> questions;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private DocType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public DocType getType() {
        return type;
    }

    public void setType(DocType type) {
        this.type = type;
    }

}
