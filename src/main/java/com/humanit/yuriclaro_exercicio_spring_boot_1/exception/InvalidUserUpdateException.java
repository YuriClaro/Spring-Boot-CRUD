package com.humanit.yuriclaro_exercicio_spring_boot_1.exception;

public class InvalidUserUpdateException extends RuntimeException{
    public InvalidUserUpdateException(String message) {
        super(message);
    }
}
