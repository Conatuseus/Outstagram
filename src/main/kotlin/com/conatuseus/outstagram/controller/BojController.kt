package com.conatuseus.outstagram.controller


import io.lettuce.core.RedisClient
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext

@RestController
class BojController{
    @GetMapping("/BOJ/add/{userId}")
    fun addUser(@PathVariable userId:String,@PathVariable addId:String):String{
        val redisClient=RedisClient.create("http://localhost:6379").connect().sync()
        redisClient.zaddincr(userId,getSolvedNumber(addId).toDouble(),addId)
        return "Success"
    }
    @GetMapping("/BOJ/list/{userId}")
    fun getList(@PathVariable userId:String):String{
        val redisClient=RedisClient.create("http://localhost:6379").connect().sync()
        return redisClient.smembers(userId).toString()
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
}