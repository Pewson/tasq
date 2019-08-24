package pl.sdacademy.tasq.results;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends CrudRepository<Results, String> {

    // #TODO extends with findBy*** Queries
}
