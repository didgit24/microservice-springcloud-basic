/*
package com.microservice.cloud.studentservice.feignClient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "address-service")
public class AddressServiceLoadBalancingConfig {

    @LoadBalanced
    @Bean
    public Feign.Builder feiBuilder() {
        return Feign.builder();
    }
}
*/
