package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo


class LolUserService(val lolUserId:String,val lolApiKey:String){

    fun lolUserInfoService():LolUserInfo=LolUserDAO(lolUserId,lolApiKey).testRetrofit()
}