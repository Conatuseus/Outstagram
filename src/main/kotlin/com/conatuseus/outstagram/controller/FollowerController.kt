package com.conatuseus.outstagram.controller

import com.conatuseus.outstagram.model.FollowerList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FollowerController {
    @GetMapping("/followers/{userId}")
    fun getFollwerListByUserId(@PathVariable userId: Int) : FollowerList {


        return FollowerList(listOf("Hello", "Hi"))
    }
}