package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import retrofit2.Call


class LolUserService(val lolUserId:String,val lolApiKey:String){

    fun lolUserInfoService(): Call<LolUserInfo> =LolUserDAO(lolUserId,lolApiKey).testRetrofit()
}