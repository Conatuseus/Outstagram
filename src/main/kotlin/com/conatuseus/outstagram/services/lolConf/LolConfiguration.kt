package com.conatuseus.outstagram.services.lolConf

import com.conatuseus.outstagram.controller.lolController.LolController
import com.conatuseus.outstagram.services.lolService.LolApiKeyService
import com.conatuseus.outstagram.services.lolService.LolUserDAO
import com.conatuseus.outstagram.services.lolService.LolUserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class LolConfiguration {

    @Bean
    fun lolApiService() = LolUserService(lolUserDAO())

    @Bean
    fun lolUserDAO() = LolUserDAO(lolApiKeyService().lolApiKey)

    @Bean
    fun lolApiKeyService() = LolApiKeyService("RGAPI-c6c2959a-786f-4d75-844a-b7bca924422c")


}