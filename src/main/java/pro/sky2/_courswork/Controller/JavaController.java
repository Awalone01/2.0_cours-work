package pro.sky2._courswork.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaController {

    private final QuestionService service;

    public JavaController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return service.addQuestion(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        return service.removeQuestion(question, answer);
    }

    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return service.getQuestions();
    }

}
