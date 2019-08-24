package pl.sdacademy.tasq.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {


    private final AnswersRepository answersRepository;

    @Autowired
    public AnswerService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    public Answer addAnswer(Answer answer){
        return answersRepository.save(answer);
    }
}
