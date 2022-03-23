package pro.sky2._courswork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky2._courswork.Service.Impl.JavaQuestionService;
import pro.sky2._courswork.data.Question;
import pro.sky2._courswork.repository.QuestionRepository;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void test_add() {
        Question question = new Question("testQ", "testA");
        when(questionRepository.addQuestion(question)).thenReturn(true, false);

        assertTrue(out.addQuestion(question));
        assertFalse(out.addQuestion(question));
    }

    @Test
    public void test_remove() {
        String questionText = "testQ";
        String answerText = "testA";
        Question question = new Question(questionText, answerText);
        when(questionRepository.removeQuestion(question)).thenReturn(true, false);

        assertTrue(out.removeQuestion(questionText, answerText));
        assertFalse(out.removeQuestion(questionText, answerText));
    }

    @Test
    public void test_get_all() {
        Set<Question> questions = Set.of(
                new Question("testQ", "testA"),
                new Question("testQ2", "testA2")
        );
        when(questionRepository.getAllQuestion()).thenReturn(questions);

        assertEquals(out.getAllQuestions().size(), questions.size());
        assertTrue(out.getAllQuestions().containsAll(questions));
    }

    @Test
    public void test_get_random_question() {
        when(questionRepository.getAllQuestion()).thenReturn(List.of(
                new Question("testQ", "testA"),
                new Question("testQ2", "testA2"),
                new Question("testQ3", "testA3")
        ));

        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(anyInt())).thenReturn(0, 2);
        out.setRandom(randomMock);

        assertEquals(new Question("testQ", "testA"), out.getRandomQuestion());
        assertEquals(new Question("testQ3", "testA3"), out.getRandomQuestion());
    }

}
