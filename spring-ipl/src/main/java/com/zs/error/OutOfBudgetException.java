package com.zs.error;

public class OutOfBudgetException extends RuntimeException {
    public OutOfBudgetException() {}
    public OutOfBudgetException(String message) {
        super(message);
    }
}
