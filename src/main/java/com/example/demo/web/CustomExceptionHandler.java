package com.example.demo.web;

import com.example.demo.service.exception.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleAccountNotFoundException(AccountNotFoundException ex) {
      ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
