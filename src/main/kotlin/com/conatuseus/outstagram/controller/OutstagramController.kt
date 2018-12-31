package com.conatuseus.outstagram.controller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OutstagramController{
    @GetMapping("/instagram")
    fun start():String{
        return "main"
    }

}