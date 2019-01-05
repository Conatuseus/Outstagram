package com.conatuseus.outstagram.controller

import com.conatuseus.outstagram.services.BojService
import io.lettuce.core.RedisClient
import io.lettuce.core.api.StatefulRedisConnection
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.support.WebApplicationContextUtils

import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext

@RestController
class BojController(@Autowired val redisClient: StatefulRedisConnection<String,String>){

    @GetMapping("/BOJ/add/{userId}")
    fun addUser(@PathVariable userId:String,@RequestParam addId:String):String{
//        val redisClient=RedisClient.create("redis://localhost:6379").connect().sync()
//        redisClient.zaddincr(userId,getSolvedNumber(addId).toDouble(),addId)
        return
    }

    @GetMapping("/BOJ/list/{userId}")
    fun getList(@PathVariable userId:String):String{
        val redisClient=RedisClient.create("redis://localhost:6379").connect().sync()
        var ret=""
        redisClient.zrangeWithScores(userId,0,10000).forEach { ret+="[${it.value} : ${it.score.toInt()}]   " }
        return ret
    }

    @GetMapping("/BOJ/{userId}")
    fun getSolvedNumber(@PathVariable userId:String):String{
        val sc = SSLContext.getInstance("SSL")
        sc.init(null, null, java.security.SecureRandom())
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
        val URL= "https://www.acmicpc.net/user/$userId"
        val response= Jsoup.connect(URL)
                .method(Connection.Method.GET)
                .execute()
        val htmlDocument=response.parse()
        val getSolvedNumber=htmlDocument.select("#statics > tbody > tr:nth-child(2) > td > a").text()

        return getSolvedNumber.toString()
    }
    @GetMapping("/reset")
    fun reset():String{
        val redisClient=RedisClient.create("redis://localhost:6379").connect().sync()
        redisClient.flushall()
        return "success!"
    }
}