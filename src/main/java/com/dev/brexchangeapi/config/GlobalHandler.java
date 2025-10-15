package com.dev.brexchangeapi.config;

import com.dev.brexchangeapi.exceptions.ExceptionResponse;
import com.dev.brexchangeapi.exceptions.MethodArgumentNotValidException;
import com.dev.brexchangeapi.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException e) {
        var exception = new ExceptionResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.name(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> methodArgumentNotValid(MethodArgumentNotValidException e) {
        var exception = new ExceptionResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.name(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
