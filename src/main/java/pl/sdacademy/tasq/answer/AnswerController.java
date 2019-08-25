package pl.sdacademy.tasq.answer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/answer")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController (AnswerService answerService){
        this.answerService = answerService;
    }

    @PostMapping("/saveAnswer")
    public  void saveAnswer (@RequestBody Answer answer){
        answerService.addAnswer(answer);
    }




//    {
//        "content": "odpowiedz1",
//            "correct": true,
//            "question": {
//        "id": "5263f882-0183-4a1a-8cb1-dd43af20c0a1"
//       }
//    }
}
