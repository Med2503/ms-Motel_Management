package com.att.exception;

import com.att.Book.RoomBookedResponse;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
public class ErrorException extends RuntimeException {
    public ErrorException(String message) {
        super(message);
    }
}
