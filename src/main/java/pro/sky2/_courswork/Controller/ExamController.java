package pro.sky2._courswork.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky2._courswork.Service.ExaminerService;
import pro.sky2._courswork.data.Question;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;


    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
