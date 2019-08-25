package pl.sdacademy.tasq.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.tasq.answer.Answer;
import pl.sdacademy.tasq.answer.AnswerService;
import pl.sdacademy.tasq.answer.AnswersRepository;
import pl.sdacademy.tasq.test.Test;
import pl.sdacademy.tasq.test.TestsRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionService {


   private final QuestionsRepository questionsRepository;
   private  final AnswersRepository answersRepository;
   AnswerService answerService;
   TestsRepository testsRepository;

   @Autowired
    public QuestionService(QuestionsRepository questionsRepository,
                           AnswersRepository answersRepository,AnswerService answerService,
                           TestsRepository testsRepository) {
        this.questionsRepository = questionsRepository;
        this.answersRepository = answersRepository;
        this.answerService = answerService;
        this.testsRepository = testsRepository;
    }


    public void addQuestion (Question question){
       // pobierz Testu po jego ID
        Test testFromDb = testsRepository.findById(question.getTest().getId()).orElseThrow(()->new NoSuchElementException("no test found!"));
        // przypisz do Pytania Obiekt pobranego (wyszukanego) testu
        question.setTest(testFromDb);
/*  // pobierz listę Pytań
    List<Answer> answersFromDb = question.getListOfAnswers().stream()
                .map((answer)->answerService.addAnswer(answer))
                .collect(Collectors.toList());
        question.setListOfAnswers(answersFromDb);*/
        questionsRepository.save(question);
        List<Question> questions = testFromDb.getQuestions();
        if(question == null){
            questions = new ArrayList<>();
        }
        questions.add(question);
        testFromDb.setQuestions(questions);
        testsRepository.save(testFromDb);
    }

    public List<Question> findAll (){
       Iterable<Question> questions = questionsRepository.findAll();
       List<Question> questionList = new ArrayList<>();
       questions.forEach(questionList::add);
       return questionList;
    }

    public Question findById(String id){
       Optional<Question> questions = questionsRepository.findById(id);
       return questions.orElseThrow(() -> new NoSuchElementException("No element with this id"));
    }


}
