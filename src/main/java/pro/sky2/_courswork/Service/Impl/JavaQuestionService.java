package pro.sky2._courswork.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;
import pro.sky2._courswork.exception.EmployeeExistException;
import pro.sky2._courswork.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private Random random = new Random();

    @Override
    public Question addQuestion(String question, String answer) {
        Question addingQuestion = new Question(question, answer);

        if (questions.contains(addingQuestion)) {
            throw new EmployeeExistException("Этот сотрудник уже добавлен");
        }
        questions.add(addingQuestion);
        return addingQuestion;
    }

    @Override
    public Question add(String question) {
        Question addingQuestion = new Question(question);

        if (questions.contains(addingQuestion)) {
            throw new EmployeeExistException("Этот сотрудник уже добавлен");
        }
        questions.add(addingQuestion);
        return addingQuestion;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question removingQuestion = new Question(question, answer);

        if (!questions.remove(removingQuestion)) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return removingQuestion;
    }

    @Override
    public Collection<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }

    @Override
    public  int getSize() {
       return questions.size();
    }

    public void setRandom(Random random) {
        this.random = random;
    }


}
