package com.homeproject.homeproject.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ServiceHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyPersonalExceptionBad.class)
    public ResponseEntity<Object> handleMyPersonalExceptionBad(MyPersonalExceptionBad ex){
        return new ResponseEntity<>(ex.getMessage(),BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleMyPersonalExceptionFound(NoSuchElementException ex){
        return new ResponseEntity<>(ex.getMessage(),NOT_FOUND);
    }

}
