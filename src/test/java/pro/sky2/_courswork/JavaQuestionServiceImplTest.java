package pro.sky2._courswork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky2._courswork.Service.Impl.JavaQuestionService;
import pro.sky2._courswork.data.Question;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService out;

    public void turnDown() {

    }

    @Test
    public void addQuestionTest() {
        Question question = new Question("q", "w");
        when(questionRepository.add(question)).thanReturn(true, false);

        assertTrue(out.add(question));
        assertFalse(out.add(question));
    }

    @Test
    public void removeQuestionTest() {
        String questionText = "q";
        String answerText = "w";
        Question question = new Question(questionText, answerText);
        when(questionRepository.remove(question)).thenReturn(true, false);

        assertTrue(out.remove(questionText, answerText));
        assertFalse(out.remove(questionText, answerText));
    }

    @Test
    public void getAllQuestionTest() {
        Set<Question> questionSet = Set.of(
                new Question("q", "w"),
                new Question("a", "s")
        );
        when(questionRepository.getAll()).thenReturn(questionSet);

        assertEquals(out.getAll().size(), questionSet.size());
        assertTrue(out.getAll().containsAll(questionSet));
    }
}
