package com.att.Book;

public record GuestResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
