package dev.kush.ratingservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handlerResourceNotFoundException(ResourceNotFoundException ex){
        ErrorDetail errorDetail = new ErrorDetail(
                ex.getMessage(), NOT_FOUND, LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDetail, NOT_FOUND);
    }
}
