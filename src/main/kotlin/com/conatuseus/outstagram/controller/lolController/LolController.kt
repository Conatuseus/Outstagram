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

    @GetMapping("/lol/summoner/{userName}")
    fun lolGetSummoner(@PathVariable userName:String):LolSummoner=lolUserService.lolGetSummonerService(userName)

    @GetMapping("/lol/matches/{userName}")
    fun lolGetMatches(@PathVariable userName: String):LolMatch=lolUserService.lolGetMatchesService(lolGetSummoner(userName).accountId)

    @GetMapping("/lol/spectator/{userName}")
    fun lolGetSpectator(@PathVariable userName: String):LolSpectator=lolUserService.lolSpectatorService(lolGetSummoner(userName).id)

    @GetMapping("/lol/find/{userName}")
    fun lolGetUseInfo(@PathVariable userName: String):String=lolUserService.lolSummonerInfoService(userName)
}