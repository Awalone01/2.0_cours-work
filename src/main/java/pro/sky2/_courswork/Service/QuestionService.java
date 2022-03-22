package pro.sky2._courswork.Service;

import pro.sky2._courswork.data.Question;

import java.util.Collection;

public interface QuestionService {

    Question addQuestion(String question, String answer);

    Question add(String question);

    Question removeQuestion(String question, String answer);

    Collection<Question> getQuestions();

    Question getRandomQuestion();

    int getSize();

}
