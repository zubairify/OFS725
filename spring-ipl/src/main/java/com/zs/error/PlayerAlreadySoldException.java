package com.zs.error;

public class PlayerAlreadySoldException extends RuntimeException {
    public PlayerAlreadySoldException() {}
    public PlayerAlreadySoldException(String message) {
        super(message);
    }
}
