package com.conatuseus.outstagram.dataAccess


class lolDataAccess(val lolUserId:String,val lolApiKey:String){
    var lolAddress="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"
    fun lolGetUserInfo(){

    }
}