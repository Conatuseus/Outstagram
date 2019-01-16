package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import retrofit2.Call


class LolUserService(private val lolUserDAO: LolUserDAO){

    fun lolUserInfoService(lolUserId: String): String {
        return lolUserDAO.getUserInfo(lolUserId).toString()
    }
}