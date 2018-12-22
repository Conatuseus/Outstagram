package com.conatuseus.outstagram.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @GetMapping("/health_check")
    fun healthCheck() : String {
        return "OK"
    }
}