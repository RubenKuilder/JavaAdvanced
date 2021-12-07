package nhlstenden.javaminor.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoDataFoundException.class)
    public ErrorResponse handleNoDataException(NoDataFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
