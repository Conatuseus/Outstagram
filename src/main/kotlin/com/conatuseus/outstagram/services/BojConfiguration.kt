package com.conatuseus.outstagram.services

import com.conatuseus.outstagram.controller.BojController
import io.lettuce.core.RedisClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BojConfiguration{
    val redisClient=RedisClient.create("redis://localhost:6379").connect()
    @Bean("BojController")
    fun bojController()=BojController(redisClient)

}