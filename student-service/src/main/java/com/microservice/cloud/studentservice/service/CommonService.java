package com.microservice.cloud.studentservice.service;

import com.microservice.cloud.studentservice.feignClient.AddressFeignClient;
import com.microservice.cloud.studentservice.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);

    long count = 1;

    @Autowired
    AddressFeignClient addressFeignClient;

    //fault tolerance change - circuit breaker method
    @CircuitBreaker(name = "adressService", fallbackMethod = "fallbackGetAddressById")
    public AddressResponse getAddressById (long addressId) {
        logger.info("count= " + count);
        count++;
        AddressResponse addressResponse = addressFeignClient.getByTd(addressId);

        return addressResponse;
    }

    //dummy fallback method
    //in case of error and switch open scenarios fall back method will get executed, and it will not fail student service
    public AddressResponse fallbackGetAddressById (long addressId, Throwable throwable) {
        logger.error("Exception: " + throwable);
        return new AddressResponse();
    }
}
