package pl.sdacademy.tasq.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.tasq.question.Question;
import pl.sdacademy.tasq.question.QuestionsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AnswerService {


    private final AnswersRepository answersRepository;
    private final QuestionsRepository questionsRepository;

    @Autowired
    public AnswerService(AnswersRepository answersRepository, QuestionsRepository questionsRepository) {
        this.answersRepository = answersRepository;
        this.questionsRepository = questionsRepository;
    }

    public Answer addAnswer(Answer answer){
        Question questionFromDB = questionsRepository.findById(answer.getQuestion().getId()).orElseThrow(()->new NoSuchElementException("Question doesnt exist"));
        answer.setQuestion(questionFromDB);
        answersRepository.save(answer);
        Optional<List<Answer>> answers = Optional.ofNullable(questionFromDB.getListOfAnswers());
        List<Answer> answerList = answers.orElseGet(ArrayList::new);
        answerList.add(answer);
        questionFromDB.setListOfAnswers(answerList);
        questionsRepository.save(questionFromDB);
        return answersRepository.save(answer);
    }
}
