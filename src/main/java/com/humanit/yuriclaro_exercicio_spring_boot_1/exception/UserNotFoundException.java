package com.humanit.yuriclaro_exercicio_spring_boot_1.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
