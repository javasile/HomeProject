package com.homeproject.homeproject.controller;

import com.homeproject.homeproject.model.AddressDto;
import com.homeproject.homeproject.repository.Address;
import com.homeproject.homeproject.service.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressServiceImpl addressService;

    @GetMapping("/allAddress")
    @ResponseStatus(OK)
    public List<AddressDto> findAllAddress() {
        return addressService.getAllAddressDto();
    }

    @PostMapping("/newAddress")
    public void createAddress(@RequestBody AddressDto addressDto) {
        addressService.createAddress(addressDto);
    }

    @GetMapping(value = "/address/{id}")
    public Address readAddressById(@PathVariable("id") UUID id) {
        return addressService.readAddressById(id);
    }

    @PutMapping("/editAddress")
    public void updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
    }

    @PatchMapping("/updateAddress")
    public void updateAddress2(@RequestBody Address address) {
        addressService.updateAddress(address);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
    }
}
