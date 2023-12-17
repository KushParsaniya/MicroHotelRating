package dev.kush.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(
            ResourceNotFoundException ex
    ){
        ErrorDetail errorDetail = new ErrorDetail(
                ex.getMessage(),HttpStatus.NOT_FOUND, LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }
}
