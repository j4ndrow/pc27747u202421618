package com.campuslab.platform.u202421618.shared.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Locale;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private final MessageTranslator messages;
    public GlobalExceptionHandler(MessageTranslator messages) { this.messages = messages; }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResource> validation(Locale locale) {
        return ResponseEntity.badRequest().body(new ErrorResource(messages.get("validation", locale)));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResource> invalidJson(Locale locale) {
        return ResponseEntity.badRequest().body(new ErrorResource(messages.get("json", locale)));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResource> unexpected(Exception error, Locale locale) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResource(messages.get("internal", locale)));
    }
}
