package com.conatuseus.outstagram.controller.bojController

import com.conatuseus.outstagram.services.bojService.BojService
import io.lettuce.core.api.StatefulRedisConnection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class BojController(@Autowired val redis:StatefulRedisConnection<String,String>,
                    @Autowired private val bojService: BojService){

    @GetMapping("/BOJ/add/{userId}")
    fun addUser(@PathVariable userId:String,@RequestParam addId:String):String{
        return bojService.addUserService(userId,addId)
    }

    @GetMapping("/BOJ/list/{userId}")
    fun getList(@PathVariable userId:String):String{
        return bojService.getListService(userId)
    }

    @GetMapping("/BOJ/{userId}")
    fun getSolvedNumber(@PathVariable userId:String):String{
        return bojService.addUserInRedis(userId)
    }

    @GetMapping("/reset")
    fun reset():String{
        redis.sync().flushall()
        return "success!"
    }
}