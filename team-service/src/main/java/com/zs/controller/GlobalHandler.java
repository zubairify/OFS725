package com.zs.controller;

import com.zs.error.OutOfBudgetException;
import com.zs.error.PlayerAlreadySoldException;
import com.zs.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException e) {
        ErrorResponse resp =
                ErrorResponse.create(e, HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.badRequest().body(resp);
    }

    @ExceptionHandler(OutOfBudgetException.class)
    public ResponseEntity<?> handleOutOfBudget(OutOfBudgetException e) {
        ErrorResponse resp =
                ErrorResponse.create(e, HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.badRequest().body(resp);
    }

    @ExceptionHandler(PlayerAlreadySoldException.class)
    public ResponseEntity<?> handlePlayerAlreadySold(PlayerAlreadySoldException e) {
        ErrorResponse resp =
                ErrorResponse.create(e, HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.badRequest().body(resp);
    }
}
