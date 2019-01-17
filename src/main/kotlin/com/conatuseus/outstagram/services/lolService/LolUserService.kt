package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo

class LolUserService(private val lolUserDAO: LolUserDAO){

    fun lolUserInfoService(lolUserId: String): LolUserInfo {
        return lolUserDAO.getUserInfo(lolUserId)
    }
}