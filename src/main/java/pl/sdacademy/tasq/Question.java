package pl.sdacademy.tasq;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name="Question")
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(generator = “UUID”)
    @GenericGenerator(
            name = “UUID”,
            strategy = “org.hibernate.id.UUIDGenerator”,
    )
    private Integer id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id")
    private Test test;

    @Column(name="text")
    private String text;

    @Column(name="points")
    private Integer points;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Answer> listOfAnswers;
    //private Answer answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public List<Answer> getListOfAnswers() {
        return listOfAnswers;
    }

    public void setListOfAnswers(List<Answer> listOfAnswers) {
        this.listOfAnswers = listOfAnswers;
    }
}
