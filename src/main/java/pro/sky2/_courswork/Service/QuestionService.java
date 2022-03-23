package pro.sky2._courswork.Service;

import pro.sky2._courswork.data.Question;

import java.util.Collection;

public interface QuestionService {

    boolean  addQuestion(String question, String answer);

    boolean addQuestion(Question question);

    boolean removeQuestion(String question, String answer);

    Collection<Question> getAllQuestions();

    Question getRandomQuestion();

    int getSize();

}
