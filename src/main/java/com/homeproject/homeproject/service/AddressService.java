package com.homeproject.homeproject.service;

import com.homeproject.homeproject.model.AddressDto;
import com.homeproject.homeproject.repository.Address;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface AddressService {

    List<AddressDto> getAllAddressDto();

    void createAddress(@Valid AddressDto addressDto);

    Address readAddressById(UUID id);

    Address updateAddress(Address address);

    void deleteAddress(UUID id);
}
