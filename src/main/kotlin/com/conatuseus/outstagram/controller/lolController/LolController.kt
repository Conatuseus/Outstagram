package com.conatuseus.outstagram.controller.lolController

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import com.conatuseus.outstagram.services.lolService.LolApiService
import com.conatuseus.outstagram.services.lolService.LolUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class LolController(private val lolUserService: LolUserService){

    @GetMapping("/lol/{userId}")
    fun lolGetInfoOfUser(@PathVariable userId:String):LolUserInfo{
//        val apiKey="RGAPI-f6fca46d-169b-4677-899b-fe6c6de67f11"
//        val url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$userId?api_key=$apiKey"
        return lolUserService.lolUserInfoService(userId)
    }


}