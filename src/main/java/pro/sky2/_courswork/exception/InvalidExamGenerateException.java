package pro.sky2._courswork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidExamGenerateException extends IllegalArgumentException {
    public InvalidExamGenerateException(String message) {
        super(message);
    }
}
