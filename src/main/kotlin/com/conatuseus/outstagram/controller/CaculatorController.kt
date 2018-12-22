package com.conatuseus.outstagram.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CaculatorController {
    @GetMapping("/add")
    fun add(@RequestParam a : Int, @RequestParam b : Int) : Int {
        return a + b
    }
}