package com.conatuseus.outstagram.services.bojService

import io.lettuce.core.api.StatefulRedisConnection
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.StringBuilder
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext

@Service("bojService")
class BojService(@Autowired val redisForUser: StatefulRedisConnection<String,String>,
                 @Autowired val redisForFriendList: StatefulRedisConnection<String,String>){

    fun addUserService(userId:String,friendId:String):String{
//        redis.sync().zaddincr(userId,getSolvedNumberService(addId).toDouble(),addId)
        redisForFriendList.sync().lpush(userId,friendId)
        return "Success"
    }

    fun getSolvedNumberService(userId:String):String{
        if(redisForUser.sync().get(userId)!=null)
            return redisForUser.sync().get(userId).toString()

        val sc = SSLContext.getInstance("SSL")
        sc.init(null, null, java.security.SecureRandom())
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
        val URL= "https://www.acmicpc.net/user/$userId"
        val response= Jsoup.connect(URL)
                .method(Connection.Method.GET)
                .execute()
        val htmlDocument=response.parse()
        val getSolvedNumber=htmlDocument.select("#statics > tbody > tr:nth-child(2) > td > a").text()
        redisForUser.sync().set(userId,getSolvedNumber)
        return getSolvedNumber
    }

    fun getListService(userId: String):String{
        var ret=""
        val st=StringBuilder(ret)
//        redis.sync().zrangeWithScores(userId,0,10000).forEach { ret+="[${it.value} : ${it.score.toInt()}]   "
        data class Pair(val id:String,val solvedNum:Int):Comparable<Pair>{
            override fun compareTo(other: Pair)=this.solvedNum-other.solvedNum
        }
        val userRedis=redisForUser.sync()
        val friend=redisForFriendList.sync().lrange(userId,0,-1)
        val friendsList=Array(friend.size+1){ if(it!=friend.size) Pair(friend[it],userRedis.get(friend[it]))
            else Pair(userId,userRedis.get(userId))
        }
        friendsList.sort()
        friendsList.forEach { st.append("${it.first} : ${it.second}") }
        return st.toString()
    }

}