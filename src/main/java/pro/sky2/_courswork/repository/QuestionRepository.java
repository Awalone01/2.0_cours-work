package pro.sky2._courswork.repository;

import pro.sky2._courswork.data.Question;

import java.util.Collection;

public interface QuestionRepository {

    boolean addQuestion(Question question);

    boolean removeQuestion(Question question);

    Collection<Question> getAllQuestion();
}
