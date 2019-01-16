package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LolApiService{

    @GET("lol/summoner/v4/summoners/by-name/{lolUserId}")
    fun getUserInfo(@Path("lolUserId") lolUserId:String,
                    @Query("api_key") lolApiKey:String):Call<LolUserInfo>

}