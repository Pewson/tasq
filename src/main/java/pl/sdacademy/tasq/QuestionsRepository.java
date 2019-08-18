package pl.sdacademy.tasq;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends CrudRepository<Question, String> {

// #TODO extends with findBy*** Queries
}
