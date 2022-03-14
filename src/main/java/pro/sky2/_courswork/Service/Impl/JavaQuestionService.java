package pro.sky2._courswork.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;

import java.util.Collection;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {


    public Set<Question> questions;

    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(String question) {
        return null;
    }

    @Override
    public Question remove(String question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
