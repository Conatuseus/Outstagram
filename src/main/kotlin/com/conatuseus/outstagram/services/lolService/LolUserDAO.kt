package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolMatch
import com.conatuseus.outstagram.model.lolModel.LolSpectator
import com.conatuseus.outstagram.model.lolModel.LolSummoner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LolUserDAO(private val lolApiKey:String){
    private val baseURL="https://kr.api.riotgames.com/"
    private val retrofit=Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LolApiService::class.java)

    fun getLolSummoner(lolUserName:String): LolSummoner{
        val response = retrofit.getUserInfo(lolUserName, lolApiKey).execute()
        return response.body()!!
    }

    fun getLolMatches(lolAccountId:String):LolMatch{
        val response=retrofit.getUserMatches(lolAccountId,lolApiKey).execute()
        return response.body()!!
    }

    fun getSpectator(lolSummonerId:String):LolSpectator{
        val response=retrofit.getUserSpectator(lolSummonerId,lolApiKey).execute()
        return response.body()!!
    }

}