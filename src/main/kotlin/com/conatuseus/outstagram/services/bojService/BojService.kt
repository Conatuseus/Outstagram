package com.conatuseus.outstagram.services.bojService

import io.lettuce.core.api.StatefulRedisConnection
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext

const val FRIEND_LIST_KEY_PREFIX="BOJ::friendList::"
const val SOLVED_NUM_KEY_PREFIX="BOJ::solvedNum::"
const val USER_LIST_KEY="BOJ::userList::"

@Service("bojService")
class BojService(@Autowired val redis: StatefulRedisConnection<String,String>) {

    fun addFriendService(userId:String,friendId:String):String{
        if(!redis.sync().sismember(USER_LIST_KEY,friendId)){
            redis.sync().sadd(USER_LIST_KEY,friendId)
        }
        if(!redis.sync().sismember(USER_LIST_KEY,userId)){
            redis.sync().sadd(USER_LIST_KEY,userId)
        }
        if(redis.sync().sismember("$FRIEND_LIST_KEY_PREFIX$userId",friendId)){
            return "Already exist"
        }
        redis.sync().sadd("$FRIEND_LIST_KEY_PREFIX$userId", friendId)
        return "Success"
    }

    fun getSolvedNumber(userId:String):String{
        if(redis.sync().get("$SOLVED_NUM_KEY_PREFIX$userId")!=null)
            return redis.sync().get("$SOLVED_NUM_KEY_PREFIX$userId").toString()

        if(!redis.sync().sismember(USER_LIST_KEY,userId)){
            redis.sync().sadd(USER_LIST_KEY,userId)
        }

        val sc = SSLContext.getInstance("SSL")
        sc.init(null, null, java.security.SecureRandom())
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
        val URL= "https://www.acmicpc.net/user/$userId"
        val response= Jsoup.connect(URL)
                .method(Connection.Method.GET)
                .execute()
        val htmlDocument =response.parse()
        val getSolvedNumber=htmlDocument.select("#statics > tbody > tr:nth-child(2) > td > a").text()
        redis.sync().set("$SOLVED_NUM_KEY_PREFIX$userId",getSolvedNumber)
        return getSolvedNumber
    }

    fun getListService(userId: String):String{
        redis.sync().sadd("$FRIEND_LIST_KEY_PREFIX$userId",userId)
        if(redis.sync().smembers("$FRIEND_LIST_KEY_PREFIX$userId").size<=1)
            return "Not Friends"
        val friends=redis.sync().smembers("$FRIEND_LIST_KEY_PREFIX$userId")
        val friendList= mutableListOf<Pair<String,Int>>()
        friends.forEach { friendList.add(Pair(it, getSolvedNumber(it).toInt())) }
        friendList.sortWith(kotlin.Comparator { o1, o2 -> o1.second.compareTo(o2.second) })
        var res="[  "
        friendList.forEach { res+="${it.first}: ${it.second}  " }
        res+="   ]"
        return res
    }


}