package com.conatuseus.outstagram.services.lolService

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LolApiService {

    @GET("/lol/{userId}")
    fun getUserInfo(@Path("userId") userName:String):Call<JsonArray>

}