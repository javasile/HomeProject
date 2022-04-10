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
public class AddressDto {

    private UUID id;
    private String streetDescription;
    private String county;
    private String city;
    private String postalCode;

}
