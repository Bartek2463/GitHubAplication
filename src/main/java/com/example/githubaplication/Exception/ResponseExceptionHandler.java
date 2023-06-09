package com.example.githubaplication.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {HttpClientErrorException.class})
    protected ResponseEntity<Object> userNotFound(
            HttpClientErrorException ex, WebRequest request) {
        CustomException customException = new CustomException();
        customException.setMessage(ex.getStatusText());
        customException.setStatus(ex.getStatusCode().value());
        return handleExceptionInternal(ex, customException,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
