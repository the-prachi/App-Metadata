package com.assignment.metadataapi.config;

import com.assignment.metadataapi.model.Metadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/*
Class: RedisConfig
Description: Config class to configure redis
Author:Prachi Gupta
 */

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Metadata> redisTemplate(){
        RedisTemplate<String,Metadata> redisTemplate = new RedisTemplate<String, Metadata>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

}


