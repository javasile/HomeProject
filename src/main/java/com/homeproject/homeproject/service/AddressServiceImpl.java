package com.homeproject.homeproject.service;

import com.homeproject.homeproject.exceptions.MyPersonalExceptionBad;
import com.homeproject.homeproject.exceptions.MyPersonalExceptionFound;
import com.homeproject.homeproject.model.AddressDto;
import com.homeproject.homeproject.repository.Address;
import com.homeproject.homeproject.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAllAddressDto() {
        return null;
    }

    @Override
    public void createAddress(@Valid AddressDto addressDto) {
        Optional<Address> addressOp = addressRepository.findById(addressDto.getId());
        if (addressOp.isPresent()) {
            throw new MyPersonalExceptionBad("Product Already Exists!");
        }
    }

    @Override
    public Address readAddressById(UUID id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new MyPersonalExceptionFound("Address Not Found!"));
    }

    @Override
    public Address updateAddress(Address address) {
        this.readAddressById(address.getId());
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(UUID id) {
        this.readAddressById(id);
        addressRepository.deleteById(id);
    }

}
