package pl.sdacademy.tasq.question;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/saveQuestion")
    public void saveQuestion (@RequestBody Question question){
        questionService.addQuestion(question);
    }

    @GetMapping("/search/all")
    public List<Question> getAllQuestions(){
        return questionService.findAll();
    }

    @GetMapping("/search/byId/{id}")
    public Question getById(String id){
        return questionService.findById(id);
    }



}


