package com.conatuseus.outstagram.dataAccess

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import com.conatuseus.outstagram.services.lolService.LolGetUser
import retrofit2.Call
import retrofit2.Retrofit


class lolDataAccess(val lolUserId:String,val lolApiKey:String):LolGetUser{
    override fun lolGetUserInfoByApiKey(lolUserId: String, apiKey: String): Call<LolUserInfo> {
        val retrofit=Retrofit.Builder()
                .baseUrl("https://kr.api.riotgames.com")
                .build()
        val lolGetUser:LolGetUser=retrofit.create(LolGetUser)

    }

    var lolAddress="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"

}