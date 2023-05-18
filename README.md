# microservice-springcloud-basic
Infybuzz microservice with spring cloud

## webclient
Used for two microservice communicating with each other. Earlier RestTemplate was use, but from spring 5, webclient is the reccomended. Webclient is the part of the spring reactive package.

## openfeign
By Openfeign we can make REST calls in declrative way. Advantage over webclient. Using open feign we just need to add interface and annotaions to make REST calls.

## netfix-eureka
Spring cloud eureka registers each microservice in the Eureka server. Service dicovery we check for the registred microservices by name and check if they are active or not. Start order - first eureka, then micro services.

## client side load balancing
Spring cloud load balancer helps on client side load balancing. It follows round robit method for load balancing. Earlier Netflix RIbbon was used.

## spring cloud api gateway
API gateway is the middleman, a separate microservice. API gateway will route the request to microservices. We won't give microservice's endpoint to consumer, we will provide the API gateway's url. API gateway will route by service name and send response back to consumer. It will use Eureka to route to actual microservices. API gateway can also implement authentication. It can also add header to request, with help of pre filter. Also post filters can be added. Filters will help to overcome cost cutting concerns. Earlier Zul was the API gateway.
