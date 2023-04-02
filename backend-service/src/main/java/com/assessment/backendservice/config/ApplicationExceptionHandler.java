package com.assessment.backendservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Global Exception handler
 */
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Map<String, String> handleInvalidFieldExceptions(MethodArgumentNotValidException exception, ServletWebRequest request) {
        Map<String, String> errorMsg = new HashMap<>();
        exception.getFieldErrors().forEach(ex -> {

            errorMsg.put(ex.getField(), ex.getDefaultMessage());
        });
        return errorMsg;
    }

}
