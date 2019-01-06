package com.conatuseus.outstagram.services

import io.lettuce.core.api.StatefulRedisConnection
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext

@Service("bojService")
class BojService(@Autowired val redis:StatefulRedisConnection<String,String>){

    fun addUserService(userId:String,addId:String):String{
        redis.sync().zaddincr(userId,getSolvedNumberService(addId).toDouble(),addId)
        return "Success"
    }

    fun getSolvedNumberService(userId:String):String{
        val sc = SSLContext.getInstance("SSL")
        sc.init(null, null, java.security.SecureRandom())
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
        val URL= "https://www.acmicpc.net/user/$userId"
        val response= Jsoup.connect(URL)
                .method(Connection.Method.GET)
                .execute()
        val htmlDocument=response.parse()
        val getSolvedNumber=htmlDocument.select("#statics > tbody > tr:nth-child(2) > td > a").text()
        return getSolvedNumber
    }

    fun getListService(userId: String):String{
        var ret=""
        redis.sync().zrangeWithScores(userId,0,10000).forEach { ret+="[${it.value} : ${it.score.toInt()}]   " }
        return ret
    }

}