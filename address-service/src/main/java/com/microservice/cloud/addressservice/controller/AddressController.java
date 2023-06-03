package com.microservice.cloud.addressservice.controller;

import com.microservice.cloud.addressservice.request.CreateAddressRequest;
import com.microservice.cloud.addressservice.response.AddressResponse;
import com.microservice.cloud.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@RefreshScope
public class AddressController {

    @Autowired
    AddressService addressService;

    @Value("${address.test}")
    private String test;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getByTd(@PathVariable long id) {
        return addressService.getByTd(id);
    }

    @GetMapping("/test")
    public String test() {
        return test;
    }
}
