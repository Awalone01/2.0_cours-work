package pro.sky2._courswork.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

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
    public boolean removeQuestion(String question, String answer) {
        return questions.remove();
    }

    @Override
    public Collection<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
