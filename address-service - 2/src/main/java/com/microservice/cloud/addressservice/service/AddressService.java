package com.microservice.cloud.addressservice.service;

import com.microservice.cloud.addressservice.entity.Address;
import com.microservice.cloud.addressservice.repo.AddressRepository;
import com.microservice.cloud.addressservice.request.CreateAddressRequest;
import com.microservice.cloud.addressservice.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {

        Address address = new Address();
        address.setCity(createAddressRequest.getCity());
        address.setStreet(createAddressRequest.getStreet());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getByTd(long id) {

        logger.info("Inside get by id: " + id);

        Address address = addressRepository.findById(id).get();

        return new AddressResponse(address);
    }
}
