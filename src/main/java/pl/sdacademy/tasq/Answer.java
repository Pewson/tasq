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

}
