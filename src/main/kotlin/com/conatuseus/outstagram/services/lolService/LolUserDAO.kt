package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//var lolAddress="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"
// https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/명슨?api_key=RGAPI-3c86f2bb-a4ee-44e6-9f4e-b138b147489c
class LolUserDAO(val lolUserId:String, val lolApiKey:String){
    val baseURL="https://kr.api.riotgames.com/"

    fun testRetrofit(): LolUserInfo{
        val retrofit:Retrofit=Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service= retrofit.create(LolApiService::class.java)
        val call=service.getUserInfo(lolUserId,lolApiKey)
        return LolUserInfo(1,"a","a",1,2,"a","a")
        //임시.
    }

}