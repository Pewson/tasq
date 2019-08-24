package pl.sdacademy.tasq.user;

//        - id (uuid) (pk)
//        - timestamp
//        - id_odpowiedzi (Odpowiedź) (fk)
//        - id_użytkownika (Użytkownik) (fk)

import org.hibernate.annotations.GenericGenerator;
import pl.sdacademy.tasq.answer.Answer;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class UserAnswer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private LocalDateTime data;
    @OneToOne(fetch = FetchType.EAGER)
    Answer answer;

    @ManyToOne(fetch = FetchType.EAGER)
    User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
