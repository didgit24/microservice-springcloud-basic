package com.microservice.cloud.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (request.getURI().toString().contains("/api/student/")) {

        }

        //Pre filter
        logger.info("Authorization: " + request.getHeaders().getFirst("Authorization"));

        //route the request to appropriate microservice
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            //Post filter
            ServerHttpResponse response = exchange.getResponse();

            logger.info("Post filter: " + response.getStatusCode());
        }));
    }
}
