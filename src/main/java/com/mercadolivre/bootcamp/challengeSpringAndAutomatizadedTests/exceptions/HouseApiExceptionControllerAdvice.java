package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.exceptions;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@ControllerAdvice
public class HouseApiExceptionControllerAdvice {
    @ExceptionHandler(value = { MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleDefault(MethodArgumentNotValidException ex, WebRequest request) {
        var responseBody = new ErrorResponseDTO();
        responseBody.setMessage(Objects.requireNonNull(ex.getFieldError()).getDefaultMessage());
        responseBody.setCause(ex.getFieldError().getField());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }
}
