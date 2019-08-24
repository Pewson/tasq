package pl.sdacademy.tasq.results;

import org.hibernate.annotations.GenericGenerator;
import pl.sdacademy.tasq.test.Test;
import pl.sdacademy.tasq.user.User;
import pl.sdacademy.tasq.user.UserAnswer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name="Results")
public class Results {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @OneToOne(fetch=FetchType.EAGER)
    private User user;
    @OneToOne(fetch = FetchType.EAGER)
    private Test test;

    private LocalDateTime data;

    @OneToMany(fetch=FetchType.EAGER)
    private List<UserAnswer> listOfAnswers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<UserAnswer> getListOfAnswers() {
        return listOfAnswers;
    }

    public void setListOfAnswers(List<UserAnswer> listOfAnswers) {
        this.listOfAnswers = listOfAnswers;
    }
}
