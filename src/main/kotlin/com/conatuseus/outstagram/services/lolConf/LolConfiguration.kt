package com.conatuseus.outstagram.services.lolConf

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
    fun lolApiKeyService() = LolApiKeyService("RGAPI-82a42335-93ff-4ea2-b495-d6c77da25861")

}