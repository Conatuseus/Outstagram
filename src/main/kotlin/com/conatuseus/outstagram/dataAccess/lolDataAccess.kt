package com.conatuseus.outstagram.dataAccess

import com.conatuseus.outstagram.model.lolModel.LolUserInfo

class lolDataAccess(val lolUserId:String,val lolApiKey:String){
    var lolUrl="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"
    fun lolGetUserInfo(){

    }
}