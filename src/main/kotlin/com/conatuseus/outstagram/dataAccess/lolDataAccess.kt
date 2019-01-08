package com.conatuseus.outstagram.dataAccess

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import com.conatuseus.outstagram.services.lolService.LolUserI
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class lolDataAccess(val lolUserId:String,val lolApiKey:String):LolUserI{
    override fun lolGetUserInfoByApiKey(lolUserId: String, apiKey: String): Call<LolUserInfo> {
        val retrofit:Retrofit=Retrofit.Builder()
                .baseUrl("https://kr.api.riotgames.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var isPossible=false
        val TeacherHowToCoding= isPossible
    }


    var lolAddress="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"

}