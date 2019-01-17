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
    fun lolGetSummoner(@PathVariable userName:String):String=lolUserService.lolGetSummonerService(userName).toString()

    @GetMapping("/lol/{userName}/matches")
    fun lolGetMatches(@PathVariable userName: String):LolMatch=lolUserService.lolGetMatchesService(lolUserService.lolGetSummonerService(userName).accountId)

    @GetMapping("/lol/{userName}/spectator")
    fun lolGetSpectator(@PathVariable userName: String):LolSpectator=lolUserService.lolSpectatorService(lolUserService.lolGetSummonerService(userName).id)
}