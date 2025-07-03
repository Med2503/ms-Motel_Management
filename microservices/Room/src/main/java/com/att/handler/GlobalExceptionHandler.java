package com.att.handler;

import com.att.Guest.exception.GuestNotFoundException;
import com.att.exception.RoomBookedException;
import com.att.exception.RoomNotFoundException;
import com.att.exception.RoomRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<String> handle(RoomNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(RoomBookedException.class)
    public ResponseEntity<String> handle(RoomBookedException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(RoomRequestException.class)
    public ResponseEntity<String> handle(RoomRequestException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Errors> handleErrors(MethodArgumentNotValidException exception) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            var field = ((FieldError) error).getField();
            var msg = error.getDefaultMessage();
            errors.put(field, msg);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Errors(errors));
    }
}
