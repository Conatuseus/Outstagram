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
class BojService(@Autowired val redis: StatefulRedisConnection<String,String>,@Autowired val redisForFriends:StatefulRedisConnection<String,String>){

    fun addUserService(userId:String,friendId:String):String{
        redisForFriends.sync().lpush(userId, friendId)
        return "Success"
    }

    fun addUserInRedis(userId:String):String{
        if(redis.sync().get(userId)!=null)
            return redis.sync().get(userId).toString()

        val sc = SSLContext.getInstance("SSL")
        sc.init(null, null, java.security.SecureRandom())
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
        val URL= "https://www.acmicpc.net/user/$userId"
        val response= Jsoup.connect(URL)
                .method(Connection.Method.GET)
                .execute()
        val htmlDocument=response.parse()
        val getSolvedNumber=htmlDocument.select("#statics > tbody > tr:nth-child(2) > td > a").text()
        redis.sync().set(userId,getSolvedNumber)
        return getSolvedNumber
    }

    fun getListService(userId: String):String{
        class Pair(val id:String,val solvedNum:Int):Comparable<Pair>{
            override fun compareTo(other: Pair)=this.solvedNum-other.solvedNum
        }

        val st=StringBuilder("")
        val userRedis=redis.sync()
        val friend=redisForFriends.sync().lrange(userId,0,-1)

        val friendsList=Array(friend.size+1){
            if(it!=friend.size)
                if(userRedis.get(friend[it])!=null) Pair(friend[it],userRedis.get(friend[it]).toInt())
                else {
                    Pair(friend[it],addUserInRedis(userRedis.get(friend[it])).toInt())
                }
            else Pair(userId,userRedis.get(userId).toInt())
        }
        friendsList.sort()
        friendsList.forEach { st.append("${it.id} : ${it.solvedNum},") }
        return st.toString()
    }

}