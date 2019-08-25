package pl.sdacademy.tasq.question;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import pl.sdacademy.tasq.Serializers.AnswerListSerializer;
import pl.sdacademy.tasq.answer.Answer;
import pl.sdacademy.tasq.test.Test;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "Question")
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "id")
    private Test test;

    @Column(name = "text")
    private String text;

    @Column(name = "points")
    private Integer points;
    @JsonSerialize(using = AnswerListSerializer.class)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Answer> listOfAnswers;
    //private answer answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
