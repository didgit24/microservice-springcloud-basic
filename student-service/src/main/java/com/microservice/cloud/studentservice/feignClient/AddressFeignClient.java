package com.microservice.cloud.studentservice.feignClient;

import com.microservice.cloud.studentservice.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "${address.service.url}", value = "address-feign-client", path = "/api/address")
//@FeignClient(value = "address-service", path = "/api/address")
@FeignClient(value = "api-gateway")
public interface AddressFeignClient {

//    @GetMapping("/getById/{id}")
//    public AddressResponse getByTd(@PathVariable long id);

    @GetMapping("/address-service/api/address/getById/{id}")
    public AddressResponse getByTd(@PathVariable long id);
}
