package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolSummoner

class LolUserService(private val lolUserDAO: LolUserDAO){

    fun lolUserInfoService(lolUserId: String): LolSummoner {
        return lolUserDAO.getUserInfo(lolUserId)
    }
}