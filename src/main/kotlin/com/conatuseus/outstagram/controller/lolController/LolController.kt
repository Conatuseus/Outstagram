package com.conatuseus.outstagram.controller.lolController

import com.conatuseus.outstagram.model.lolModel.LolMatch
import com.conatuseus.outstagram.model.lolModel.LolSpectator
import com.conatuseus.outstagram.model.lolModel.LolSummoner
import com.conatuseus.outstagram.services.lolService.LolUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class LolController(private val lolUserService: LolUserService){

    @GetMapping("/lol/{userName}")
    fun lolGetSummoner(@PathVariable userName:String):LolSummoner{
//        val apiKey="RGAPI-f6fca46d-169b-4677-899b-fe6c6de67f11"
//        val url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$userId?api_key=$apiKey"
        return lolUserService.lolGetSummonerService(userName)
    }

    @GetMapping("/lol/{userName}/matches")
    fun lolGetMatches(@PathVariable userName: String):LolMatch{
        return lolUserService.lolGetMatchesService(lolGetSummoner(userName).accountId)
    }

    @GetMapping("/lol/{userName}/spectator")
    fun lolGetSpectator(@PathVariable userName: String):LolSpectator{
        return lolUserService.lolSpectatorService(lolGetSummoner(userName).id)
    }

}