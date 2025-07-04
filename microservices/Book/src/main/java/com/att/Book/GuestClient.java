package com.att.Book;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "Guest-service",
        url = "${application.config.guest-url}"
)
public interface GuestClient {

    @GetMapping("/{guest-id}")
    Optional<GuestResponse> findGuestById(@PathVariable("guest-id") String guestId);

}
