package pro.sky2._courswork.Service;

import pro.sky2._courswork.data.Question;

import java.util.Collection;
import java.util.Set;

public interface QuestionService {

    Question addQuestion(String question, String answer);

    Question addQuestion(Question question);

    Question removeQuestion(String question, String answer);

    Set<Question> getQuestions();

    Question getRandomQuestion();

}
