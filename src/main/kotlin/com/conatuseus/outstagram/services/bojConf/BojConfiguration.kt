package com.conatuseus.outstagram.services.bojConf

import io.lettuce.core.RedisClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BojConfiguration{
    @Bean
    fun redis()= RedisClient.create("redis://localhost:6379").connect()
}