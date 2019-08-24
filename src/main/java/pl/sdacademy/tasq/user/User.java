package pl.sdacademy.tasq.user;

import org.hibernate.annotations.GenericGenerator;
import pl.sdacademy.tasq.test.Test;

import javax.persistence.*;
import java.util.List;

/*5. Użytkownik
- id (uuid) (pk)
- imię
- nazwisko
- lista testów (fk)
*/
@Entity(name="User")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    private  String name;
    private  String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
