package com.conatuseus.outstagram.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.net.URL


@RestController
class LolController{

    @GetMapping("/lol/{user}")
    fun getInfoOfUser(@PathVariable userId:String){
        val apiKey="RGAPI-55af9787-2fb8-4e57-9cb4-75b049751650"
        val url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$userId?api_key=$apiKey"

    }
}