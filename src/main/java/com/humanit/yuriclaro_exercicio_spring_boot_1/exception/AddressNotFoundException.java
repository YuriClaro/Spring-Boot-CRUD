package com.humanit.yuriclaro_exercicio_spring_boot_1.exception;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(String message) {
        super(message);
    }
}
