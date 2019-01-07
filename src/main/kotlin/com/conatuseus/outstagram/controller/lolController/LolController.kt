package com.conatuseus.outstagram.controller.lolController

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class LolController{

    @GetMapping("/lol/{user}")
    fun lolGetInfoOfUser(@PathVariable userId:String){
//        val apiKey="RGAPI-f6fca46d-169b-4677-899b-fe6c6de67f11"
//        val url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$userId?api_key=$apiKey"
    }
}