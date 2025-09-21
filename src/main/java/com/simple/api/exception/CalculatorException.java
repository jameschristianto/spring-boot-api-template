package com.simple.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.simple.api.dto.CalculatorResponseDTO;
import com.simple.api.enums.CalculatorResponseEnums;
import com.simple.api.enums.StatusLevelEnums;

@RestControllerAdvice
public class CalculatorException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CalculatorResponseDTO<Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        CalculatorResponseDTO<Object> response = new CalculatorResponseDTO<>(
            StatusLevelEnums.ERROR.getLevel(),
            CalculatorResponseEnums.VALUE_REQUIRED.getCode(),
            CalculatorResponseEnums.VALUE_REQUIRED.getMessage(),
            null
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CalculatorResponseDTO<Object>> handleInvalidJson(HttpMessageNotReadableException ex) {
        CalculatorResponseDTO<Object> response = new CalculatorResponseDTO<>(
            StatusLevelEnums.ERROR.getLevel(),
            CalculatorResponseEnums.INVALID_INPUT_TYPE.getCode(),
            CalculatorResponseEnums.INVALID_INPUT_TYPE.getMessage(),
            null
        );
        return ResponseEntity.badRequest().body(response);
    }
}