package com.homeproject.homeproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private AddressDto address;


}
