package com.example.gatewayservice.filters;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
@Slf4j
@RequiredArgsConstructor
public class UserLimiter implements GatewayFilter {


    @Qualifier("userBucket")
    private final Bucket bucket;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//
//        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
//        if (!probe.isConsumed()) {
//
//            log.info("Запрос отклонен");
//            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
//            exchange.getResponse().setComplete();
//        } else {
//            log.info("Запрос выполнен");
//        }


        return chain.filter(exchange);
    }
}
