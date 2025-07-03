package com.att.Guest;


import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Validated
public class Location {

    private String street;
    private String houseNumber;
    private String zipCode;
}
