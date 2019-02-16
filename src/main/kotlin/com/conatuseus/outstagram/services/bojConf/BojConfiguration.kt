package com.conatuseus.outstagram.services.bojConf

import com.conatuseus.outstagram.services.bojService.BojService
import io.lettuce.core.RedisClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BojConfiguration{
    @Bean
    fun redisForUser()= RedisClient.create("redis://localhost:6379").connect()

    @Bean
    fun redisForFriendList()=RedisClient.create("redis://localhost:6380").connect()

    @Bean
    fun bojService()=BojService(redisForUser(),redisForFriendList())

}