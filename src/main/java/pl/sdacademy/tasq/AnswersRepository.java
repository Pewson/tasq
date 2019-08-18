package pl.sdacademy.tasq;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends CrudRepository<Answer, String> {

    // #TODO extends with findBy*** Queries
}
