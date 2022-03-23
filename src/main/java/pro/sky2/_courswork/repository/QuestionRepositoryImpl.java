package pro.sky2._courswork.repository;

import org.springframework.stereotype.Repository;
import pro.sky2._courswork.data.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository("javaRepository")
public class QuestionRepositoryImpl implements QuestionRepository{
    private final Set<Question> questions;

    public QuestionRepositoryImpl() {
        questions = new HashSet<>();
    }

    @Override
    public boolean addQuestion(Question question) {
        return questions.add(question);
    }

    @Override
    public boolean removeQuestion(Question question) {
        return questions.remove(question);
    }

    @Override
    public Collection<Question> getAllQuestion() {
        return questions;
    }
}
