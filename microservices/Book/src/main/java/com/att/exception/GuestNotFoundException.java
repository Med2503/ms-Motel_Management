package com.att.exception;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class GuestNotFoundException extends RuntimeException {
    public GuestNotFoundException(String message) {
        super(message);
    }
}
