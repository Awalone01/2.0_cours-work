package pro.sky2._courswork.Service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pro.sky2._courswork.Service.ExaminerService;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;
import pro.sky2._courswork.exception.InvalidExamGenerateException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getSize();
        if (amount <= 0 || size < amount) {
            throw new InvalidExamGenerateException("Запрашиваемое количество должно быть положительным и не быть больше чем размер коллекции");
        }

        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
