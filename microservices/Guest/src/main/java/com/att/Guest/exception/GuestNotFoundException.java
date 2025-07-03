package com.att.Guest.exception;


import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data

public class GuestNotFoundException extends RuntimeException {

    private String message;

    public GuestNotFoundException(String message) {
        this.message = message;
    }
}
