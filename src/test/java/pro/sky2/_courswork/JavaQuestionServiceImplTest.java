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
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void test_add() {
        Question question = new Question("testQ", "testA");
        when(repository.add(question)).thenReturn(true, false);

        assertTrue((BooleanSupplier) out.add(String.valueOf(question)));
        assertFalse((BooleanSupplier) out.add(String.valueOf(question)));
    }

    @Test
    public void test_remove() {
        Question question = new Question("testQ", "testA");
        when(repository.remove(question)).thenReturn(true, false);

        assertTrue((BooleanSupplier) out.removeQuestion("testQ", "testA"));
        assertFalse((BooleanSupplier) out.removeQuestion("testQ", "testA"));
    }

    @Test
    public void test_get_all() {
        Set<Question> questions = Set.of(
                new Question("testQ", "testA"),
                new Question("testQ2", "testA2")
        );
        when(repository.getAll()).thenReturn(questions);

        assertEquals(out.getQuestions().size(), questions.size());
        assertTrue(out.getQuestions().containsAll(questions));
    }

    @Test
    public void test_get_random_question() {
        when(repository.getAll()).thenReturn(List.of(
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
