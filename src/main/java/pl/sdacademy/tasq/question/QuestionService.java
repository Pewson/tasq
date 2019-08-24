package pl.sdacademy.tasq.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.tasq.answer.Answer;
import pl.sdacademy.tasq.answer.AnswerService;
import pl.sdacademy.tasq.answer.AnswersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {


   private final QuestionsRepository questionsRepository;
   private  final AnswersRepository answersRepository;
   AnswerService answerService;

   @Autowired
    public QuestionService(QuestionsRepository questionsRepository,
                           AnswersRepository answersRepository,AnswerService answerService) {
        this.questionsRepository = questionsRepository;
        this.answersRepository = answersRepository;
        this.answerService = answerService;

    }


    public void addQuestion (Question question){
        List<Answer> answersFromDb = question.getListOfAnswers().stream()
                .map((answer)->answerService.addAnswer(answer))
                .collect(Collectors.toList());
        question.setListOfAnswers(answersFromDb);
        questionsRepository.save(question);

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
