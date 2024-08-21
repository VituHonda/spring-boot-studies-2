package com.github.vituhonda.ms_pagamentos.controller.handlers;

import com.github.vituhonda.ms_pagamentos.controller.exception.ResourceNotFoundException;
import com.github.vituhonda.ms_pagamentos.dto.CustomErrorDTO;
import com.github.vituhonda.ms_pagamentos.dto.ValidationErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDTO> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        CustomErrorDTO errorDTO = new CustomErrorDTO(Instant.now().toString(), status.value(), exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(errorDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDTO> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationErrorDTO validationError = new ValidationErrorDTO(Instant
                .now().toString(), status.value(), "Dados inválidos", request.getRequestURI());
        for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(validationError);
    }
}
