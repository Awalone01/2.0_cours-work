package pro.sky2._courswork.Service.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;
import pro.sky2._courswork.repository.QuestionRepository;

import java.util.*;

@Service("javaService")
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private Random random = new Random();

    public JavaQuestionService(@Qualifier("javaRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public boolean addQuestion(String question, String answer) {
        return addQuestion(new Question(question, answer));
    }

    @Override
    public boolean addQuestion(Question question) {
        return questionRepository.addQuestion(question);
    }

    @Override
    public boolean removeQuestion(String question, String answer) {
        return questionRepository.removeQuestion(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return Set.copyOf(questionRepository.getAllQuestion());
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = List.copyOf(questionRepository.getAllQuestion());
        return questions.get(random.nextInt(questions.size()));
    }

    @Override
    public int getSize() {
        return questionRepository.getAllQuestion().size();
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}



//    @Override
//    public boolean add(String question, String answer) {
//        return add(new Question(question, answer));
//    }
//
//    @Override
//    public Question add(String question) {
//        Question addingQuestion = new Question(question);
//
//        if (javaQuestionRepository.contains(addingQuestion)) {
//            throw new EmployeeExistException("Этот сотрудник уже добавлен");
//        }
//        javaQuestionRepository.add(addingQuestion);
//        return addingQuestion;
//    }
//
//    @Override
//    public Question removeQuestion(String question, String answer) {
//        Question removingQuestion = new Question(question, answer);
//
//        if (!questions.remove(removingQuestion)) {
//            throw new EmployeeNotFoundException("Этот сотрудник не найден");
//        }
//        return removingQuestion;
//    }
//
//    @Override
//    public Collection<Question> getQuestions() {
//        return questions;
//    }
//
//    @Override
//    public Question getRandomQuestion() {
//        return List.copyOf(questions).get(random.nextInt(questions.size()));
//    }
//
//    @Override
//    public  int getSize() {
//       return questions.size();
//    }
//
//    public void setRandom(Random random) {
//        this.random = random;
//    }

