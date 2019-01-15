package com.conatuseus.outstagram.dataAccess

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//var lolAddress="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"

class LolUserDAO(val lolUserId:String, val lolApiKey:String){
    val baseURL="https://kr.api.riotgames.com/"
    var lolSummonerURL="lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"

    fun testRetrofit(){
        val retrofit:Retrofit=Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

}