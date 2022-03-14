package pro.sky2._courswork.Controller;

import org.springframework.web.bind.annotation.RestController;
import pro.sky2._courswork.Service.ExaminerService;

@RestController
public class ExamController {

    private final ExaminerService examinerService;


    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


}
