package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//var lolAddress="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"
// https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/maldive?api_key=RGAPI-1600ca23-2159-4a26-a68d-28fb37028014
class LolUserDAO(private val lolApiKey:String){
    private val baseURL="https://kr.api.riotgames.com/"
    private val retrofit=Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LolApiService::class.java)

    fun getUserInfo(lolUserId:String): LolUserInfo{
        val response = retrofit.getUserInfo(lolUserId, lolApiKey).execute()

        return response.body()!!
    }
}