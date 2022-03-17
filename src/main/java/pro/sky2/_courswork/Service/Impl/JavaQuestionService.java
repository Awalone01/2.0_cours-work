package pro.sky2._courswork.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    Random random = new Random();


    @Override
    public Question addQuestion(String question, String answer) {
        Question addingQuestion = new Question(question, answer);
        questions.add(addingQuestion);
        return addingQuestion;
    }

    @Override
    public Question addQuestion(Question question) {
        return null;
    }

    @Override
    public Question removeQuestion(String question, String answer) {

        Question removingQuestion = new Question(question, answer);

        return removingQuestion;
    }

    @Override
    public Set<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
