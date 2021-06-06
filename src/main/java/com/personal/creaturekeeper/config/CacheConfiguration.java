package com.personal.creaturekeeper.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public Caffeine caffeineConfig(@Value("${cache.ttl:PT2H}") Duration ttl,
            @Value("${cache.initial.capacity}") int initialCapacity,
            @Value("${cache.max.capacity}") int maxCapacity) {
        return Caffeine.newBuilder()
                .initialCapacity(initialCapacity)
                .maximumSize(maxCapacity)
                .expireAfterAccess(ttl);
    }

    @Bean
    public CacheManager cacheManager(Caffeine caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("creaturePayload");
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }

}
