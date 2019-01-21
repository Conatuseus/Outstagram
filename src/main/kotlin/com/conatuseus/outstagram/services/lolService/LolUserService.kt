package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolMatch
import com.conatuseus.outstagram.model.lolModel.LolSpectator
import com.conatuseus.outstagram.model.lolModel.LolSummoner

class LolUserService(private val lolUserDAO: LolUserDAO){

    fun lolGetSummonerService(lolUserName: String): LolSummoner {
        return lolUserDAO.getLolSummoner(lolUserName)
    }
    fun lolGetMatchesService(lolUserName: String):LolMatch{
        return lolUserDAO.getLolMatches(lolUserName)
    }

    fun lolSpectatorService(lolUserName: String):LolSpectator{
        return lolUserDAO.getSpectator(lolUserName)
    }
    fun lolSummonerInfoService(lolUserName:String):String{
        val user:LolSummoner=lolUserDAO.getLolSummoner(lolUserName)
        val match:LolMatch=lolUserDAO.getLolMatches(user.accountId)
        return "소환사명: ${user.name} 레벨: ${user.summonerLevel} 티어:"
    }
}