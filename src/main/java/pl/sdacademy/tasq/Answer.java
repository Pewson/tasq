package pl.sdacademy.tasq;

//        - id (uuid) (pk)
//        - treść
//        - id_pytania (fk) (Pytanie)
//        - poprawność/status


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String content;
    @ManyToOne(fetch = FetchType.EAGER)
    private Question question;
    private Boolean isCorrect;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
