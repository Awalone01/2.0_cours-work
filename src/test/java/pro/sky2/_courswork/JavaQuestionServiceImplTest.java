package pro.sky2._courswork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky2._courswork.Service.Impl.JavaQuestionService;
import pro.sky2._courswork.Service.QuestionService;
import pro.sky2._courswork.data.Question;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky2._courswork.ConstantsForTests.FIRST_ANSWER;
import static pro.sky2._courswork.ConstantsForTests.FIRST_QUESTION;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void addQuestionTest() {
        Question expectedQuestion = new Question(FIRST_QUESTION, FIRST_ANSWER);
        assertEquals(0, out.getQuestions().size());
        Question actualQuestion = out.addQuestion(FIRST_QUESTION, FIRST_ANSWER);
        assertEquals(expectedQuestion, actualQuestion);
        assertEquals(1, out.getQuestions().size());
        assertTrue(out.getQuestions().contains(expectedQuestion));
    }

//    @Test
//    public void removeQuestionTest() {
//        String questionText = "q";
//        String answerText = "w";
//        Question question = new Question(questionText, answerText);
//        when(questionService.removeQuestion(question)).thenReturn(true, false);
//
//        assertTrue(out.removeQuestion(questionText, answerText));
//        assertFalse(out.removeQuestion(questionText, answerText));
//    }
//
//    @Test
//    public void getAllQuestionTest() {
//        Set<Question> questionSet = Set.of(
//                new Question("q", "w"),
//                new Question("a", "s")
//        );
//        when(questionService.getQuestions()).thenReturn(questionSet);
//
//        assertEquals(out.getQuestions().size(), questionSet.size());
//        assertTrue(out.getQuestions().containsAll(questionSet));
//    }
}
