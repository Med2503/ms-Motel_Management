package com.att.Book;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record BookResponse(

        Integer id,
        String reference,
        BigDecimal amount,
        BillingMethod method,
        String guestId

) {

}
