package com.conatuseus.outstagram.services.bojService

import io.lettuce.core.api.StatefulRedisConnection
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.springframework.scheduling.annotation.Scheduled
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext


class BojJob(val redis:StatefulRedisConnection<String,String>){

    @Scheduled(cron = "0 /1 * * * ?")
    fun solvedNumJob(){
        val list=redis.sync().smembers(USER_LIST_KEY)
        val sc = SSLContext.getInstance("SSL")
        sc.init(null, null, java.security.SecureRandom())
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)

        for(userId in list){
            val url= "https://www.acmicpc.net/user/$userId"
            val response= Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .execute()
            val htmlDocument =response.parse()
            val getSolvedNumber=htmlDocument.select("#statics > tbody > tr:nth-child(2) > td > a").text()
            redis.sync().set("$SOLVED_NUM_KEY_PREFIX$userId",getSolvedNumber)
        }
    }
}