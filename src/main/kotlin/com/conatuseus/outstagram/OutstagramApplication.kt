package com.conatuseus.outstagram

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class OutstagramApplication

fun main(args: Array<String>) {
    runApplication<OutstagramApplication>(*args)
}