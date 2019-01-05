package com.conatuseus.outstagram.services

import com.conatuseus.outstagram.controller.BojController
import io.lettuce.core.RedisClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BojConfiguration{

    @Bean()
    fun redis()=RedisClient.create("redis://localhost:6379").connect()

    @Bean("bojController")
    fun bojController()=BojController(redis(),bojService())

    @Bean("bojService")
    fun bojService()=BojService(redis())



}