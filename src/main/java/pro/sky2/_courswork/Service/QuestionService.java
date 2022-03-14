package pro.sky2._courswork.Service;

import pro.sky2._courswork.data.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(String question);

    Question remove(String question);

    Collection<Question>getAll();

    Question getRandomQuestion();

}
