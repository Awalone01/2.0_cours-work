package pro.sky2._courswork.repository;

import pro.sky2._courswork.data.Question;

import java.util.Collection;

public interface QuestionRepository {

    boolean add(Question question);

    boolean remove(Question question);

    Collection<Question> getAll();
}
