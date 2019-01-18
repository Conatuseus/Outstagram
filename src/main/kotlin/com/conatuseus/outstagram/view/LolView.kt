package com.conatuseus.outstagram.view

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry


@Configuration
@EnableWebMvc
class LolView{

    @Override
    fun addResourceHandlers(registry:ResourceHandlerRegistry){
        registry.addResourceHandler("/LolHTML.html").addResourceLocations("LolHTML.html")
    }
}