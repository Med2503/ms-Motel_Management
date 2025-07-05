package com.example.payment;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String BookingReference,
        BigDecimal amount,
        BillingMethod billingMethod,
        String guestFirstname,
        String guestLastname,
        String guestEmail


) {

}
