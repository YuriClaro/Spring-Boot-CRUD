package com.humanit.yuriclaro_exercicio_spring_boot_1.exception;

public class InvalidAddressUpdateException extends RuntimeException{
    public InvalidAddressUpdateException(String message) {
        super(message);
    }
}
