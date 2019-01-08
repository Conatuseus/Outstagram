package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface LolUserI {

    @GET("/lol/summoner/v4/summoners/by-name/{userId}?api_key={apiKey}")
    fun lolGetUserInfoByApiKey(@Path("userId") lolUserId:String,@Path("apiKey") apiKey:String):Call<LolUserInfo>


}