package pl.sdacademy.tasq;

//        - id (uuid) (pk)
//        - timestamp
//        - id_odpowiedzi (Odpowiedź) (fk)
//        - id_użytkownika (Użytkownik) (fk)

import org.hibernate.annotations.GenericGenerator;

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
}
