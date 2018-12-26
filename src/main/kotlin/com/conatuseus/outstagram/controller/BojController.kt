package com.conatuseus.outstagram.controller


import org.jsoup.Connection
import org.jsoup.Jsoup
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BojController{
    @GetMapping("/BOJ/{userId}")
    fun getSolvedNumber(@PathVariable userId:String):String{
        val URL= "https://www.acmicpc.net/user/$userId"
//        val response= Jsoup.connect(URL)
//                .method(Connection.Method.GET)
//                .execute()
//
//        val htmlDocument=response.parse()
//        val getSolvedNumber=htmlDocument.select("#statics > tbody > tr:nth-child(2) > td > a").text()

        val doc=Jsoup.connect(URL).get()
        val contents=doc.select("#statics > tbody > tr:nth-child(2) > td > a")

        return contents.toString()
    }
}