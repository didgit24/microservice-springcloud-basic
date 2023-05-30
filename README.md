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
API gateway is the middleman, a separate microservice. API gateway will route the request to microservices. We won't give microservice's endpoint to consumer, we will provide the API gateway's url. API gateway will route by service name and send response back to consumer. It will use Eureka to route to actual microservices. API gateway can also implement authentication. It can also add header to request, with help of pre filter. Also post filters can be added. Filters will help to overcome cost cutting concerns. Earlier Zul was the API gateway. API gateway can also do the load balancing using the api-gateway feign client(server side load balancing).

## fault tolerance and circuit breaker
- Failures in microservice: Services can be down. We can use Resilience4j to check for the failures.
- Fault tolerance: Issue should not get cascaded to other microservices. How much fault can a microservice manage.
- Circuit Breaker: Break the connection to faulty microservice, so that cascading failures doen't happen. If any failure in microservice, the flow won't reach to that flow. It is a design pattern.
- Circuit Breaker States: Closed(All calls allowed), Open(No call allowed), Half open(Few calls will be allowed). From open to closed can't be done, it will go through Half-open state.
- Circuit Breaker Properties: slidingWindowSize(How many last calls to be considered, Numeric value), failureRateThresold(How much percentage of failure is allowed), waitDurationInOpenState(How many secods we want to wait in open state), Automatic from Open to Half-Open, permittedNumberOfCallsInHalfOpenState(How many calls allowed in half open). If Failure Rate>Thresold it will go to open state. Otherwise it will go to close state.
- Fallback method: Same method signature as circuit breaker method. FOr failure and switch open scenarios this will get executed.
- Do not use circuit breaker if you want to use some critical data, do not return dummy response.
- Earlier spring cloud hysterix was used for fault tolerance.


