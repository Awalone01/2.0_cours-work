package pro.sky2._courswork.Service.Impl;

import org.springframework.stereotype.Service;

import pro.sky2._courswork.Service.ExaminerService;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;

import java.util.Collection;
import java.util.Random;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
