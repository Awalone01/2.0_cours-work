package pro.sky2._courswork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeExistException extends RuntimeException {

    public EmployeeExistException(String massage) {
        super(massage);
    }
}
