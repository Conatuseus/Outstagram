package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface LolApiINF {

    @GET("/lol/{userId}/repos")
    fun lolGetRepos(@Path("userId") lolUserId:String):Call<LolUserInfo>

    @POST("lol/{userId}")
    fun lolpostRepos(@Path("userId") lolUserId:String,@Body lolUser:LolUserInfo):Call<LolUserInfo>


}