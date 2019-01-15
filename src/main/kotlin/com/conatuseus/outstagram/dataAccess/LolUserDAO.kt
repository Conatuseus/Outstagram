package com.conatuseus.outstagram.dataAccess


//var lolAddress="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"

class LolUserDAO(val lolUserId:String, val lolApiKey:String){
    var lolSummonerURL="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"


}