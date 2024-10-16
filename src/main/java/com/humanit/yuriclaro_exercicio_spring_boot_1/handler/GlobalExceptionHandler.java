package com.humanit.yuriclaro_exercicio_spring_boot_1.handler;

import com.humanit.yuriclaro_exercicio_spring_boot_1.exception.AddressNotFoundException;
import com.humanit.yuriclaro_exercicio_spring_boot_1.exception.InvalidAddressUpdateException;
import com.humanit.yuriclaro_exercicio_spring_boot_1.exception.InvalidUserUpdateException;
import com.humanit.yuriclaro_exercicio_spring_boot_1.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<String> handleAddressNotFoundException(AddressNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured: " + e.getMessage());
    }

    @ExceptionHandler(InvalidAddressUpdateException.class)
    public ResponseEntity<String> handleInvalidAddressUpdateException(InvalidAddressUpdateException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured: " + e.getMessage());
    }

    @ExceptionHandler(InvalidUserUpdateException.class)
    public ResponseEntity<String> handleInvalidUserUpdateException(InvalidUserUpdateException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured: " + e.getMessage());
    }
}
