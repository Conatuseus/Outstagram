package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolMatch
import com.conatuseus.outstagram.model.lolModel.LolSummoner

class LolUserService(private val lolUserDAO: LolUserDAO){

    fun lolGetSummonerService(lolUserName: String): LolSummoner {
        return lolUserDAO.getLolSummoner(lolUserName)
    }
    fun lolGetMatchesService(lolUserName: String):LolMatch{
        return lolUserDAO.getLolMatches(lolUserName)
    }
}