package ru.jabes.flat_rent_new.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.jabes.flat_rent_new.dto.ValidationError;
import ru.jabes.flat_rent_new.exception.ApartmentValidationException;

import java.util.List;

//@RestControllerAdvice = @ControllerAdvice + @ResponseBody
@RestControllerAdvice
public class ApartmentExceptionHandler {

    @ExceptionHandler(ApartmentValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ValidationError> handleValidation(ApartmentValidationException exception) {
        return exception.getErrors();
    }
}
