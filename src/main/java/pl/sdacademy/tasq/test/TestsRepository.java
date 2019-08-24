package pl.sdacademy.tasq.test;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.tasq.author.Author;

import java.util.Optional;

@Repository
public interface TestsRepository extends CrudRepository<Test, String> {

    Optional<Test> findByTitle(String title);
    Iterable<Test> findByType(String type);
    Iterable<Test> findByAuthor(Author author);

    // #TODO extends with findBy*** Queries
}
