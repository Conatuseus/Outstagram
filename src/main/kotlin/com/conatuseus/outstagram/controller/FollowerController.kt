package com.conatuseus.outstagram.controller

import com.conatuseus.outstagram.model.FollowerList
import io.lettuce.core.RedisClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FollowerController {
    @GetMapping("/follower/add/{userId}")
    fun addFollower(@PathVariable userId: Int, @RequestParam follwerId: Int): String {
        val redisClient = RedisClient.create("localhost").connect().sync()
        redisClient.sadd(userId.toString(), follwerId.toString())
        return "OK"
    }

    @GetMapping("/follower/{userId}")
    fun getFollwerListByUserId(@PathVariable userId: Int) : String {
        val redisClient = RedisClient.create("localhost").connect().sync()

        return redisClient.smembers(userId.toString()).toString()
    }
}