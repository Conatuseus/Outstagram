package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolApiKey


class LolApiKeyService(val newLolApiKey: String){
    fun lolInsertApiKey(lolApiKey: String)=LolApiKey(lolApiKey)

    fun lolGetApiKey():String=LolApiKey(newLolApiKey).toString()
    
}