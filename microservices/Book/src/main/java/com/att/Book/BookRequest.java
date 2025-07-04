package com.att.Book;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record BookRequest(
        Integer id,
        String reference,
        @Positive(message = "amount should be positive")
        BigDecimal amount,
        @NotNull(message = "method should be declared")
        BillingMethod method,
        @NotNull(message = "guest should be present")
        @NotEmpty(message = "guest should be present")
        @NotBlank(message = "guest should be present")
        String guestId,
        @NotEmpty(message = "book a room is mandatory!")
        List<BookedRoomRequest> rooms

) {
}
