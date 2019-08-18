package pl.sdacademy.tasq;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends CrudRepository<Test, String> {

    // #TODO extends with findBy*** Queries
}
