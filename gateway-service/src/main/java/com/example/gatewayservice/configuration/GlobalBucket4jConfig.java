package com.example.gatewayservice.configuration;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;


@Configuration
public class GlobalBucket4jConfig {
//todo задействовать логику enabled
    @Value("${global-bucket4j.enabled}")
    private boolean enabled;

    @Value("${global-bucket4j.in-memory.allowed.calls}")
    private long allowedCalls;

    @Value("${global-bucket4j.in-memory.time.duration}")
    private long timeDuration;

    @Value("${global-bucket4j.in-memory.time.unit}")
    private ChronoUnit timeUnit;

    @Value("${global-bucket4j.in-memory.tokens.limit}")
    private long tokensLimit;

    @Bean(name="globalBucket")
    public Bucket createBucket() {
        Bandwidth limit = Bandwidth.classic(allowedCalls, Refill.intervally(tokensLimit, Duration.of(timeDuration, timeUnit)));
        return Bucket4j.builder().addLimit(limit).build();
    }
}




