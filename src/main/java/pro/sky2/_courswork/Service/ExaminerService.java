package pro.sky2._courswork.Service;

import pro.sky2._courswork.data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
