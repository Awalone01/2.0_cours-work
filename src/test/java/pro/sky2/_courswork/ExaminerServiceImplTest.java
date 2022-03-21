package pro.sky2._courswork;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky2._courswork.Service.Impl.ExaminerServiceImpl;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;
import pro.sky2._courswork.exception.InvalidExamGenerateException;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {

    private ExaminerServiceImpl out;
    private QuestionService firstMock;
    private QuestionService secondMock;


//    @BeforeEach
//    public void setUp() {
//        firstMock = mock(QuestionService.class);
//        secondMock = mock(QuestionService.class);
//
//
//        out = new ExaminerServiceImpl();
//    }

    @Test
    public void amountTest() {
        assertThrows(InvalidExamGenerateException.class, () ->
                out.getQuestions(-1));
        assertThrows(InvalidExamGenerateException.class, () ->
                out.getQuestions(0));
    }

    @Test
    public void getRandomQuestionsTest() {
        when(firstMock.getRandomQuestion()).thenReturn(
                new Question("mock1_question1", "mock1_answer1"),
                new Question("mock1_question2", "mock1_answer2")
        );

        when(secondMock.getRandomQuestion()).thenReturn(
                new Question("mock2_question1", "mock2_answer1"),
                new Question("mock2_question2", "mock2_answer2"),
                new Question("mock2_question3", "mock2_answer3")
        );

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0, 1, 1, 0, 1);
        out.setRandom(mockRandom);

        Collection<Question> actualCollection = out.getQuestions(5);
        List<Question> expectedCollection = of(
                new Question("mock1_question1", "mock1_answer1"),
                new Question("mock2_question1", "mock2_answer1"),
                new Question("mock2_question2", "mock2_answer2"),
                new Question("mock1_question2", "mock1_answer2"),
                new Question("mock2_question3", "mock2_answer3")
        );

        assertIterableEquals(expectedCollection, actualCollection);
    }
}
