package com.conatuseus.outstagram.controller.lolController

import com.conatuseus.outstagram.services.lolService.LolUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class LolController{

    @GetMapping("/lol/{userId}")
    fun lolGetInfoOfUser(@PathVariable userId:String):String{
//        val apiKey="RGAPI-f6fca46d-169b-4677-899b-fe6c6de67f11"
//        val url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$userId?api_key=$apiKey"
        return LolUserService(userId,"RGAPI-3c86f2bb-a4ee-44e6-9f4e-b138b147489c").lolUserInfoService().toString()
    }
}