package com.luna.fitness_app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class Controller {

    @GetMapping("index")
    fun index(): String {
        return "Hello world!"
    }
}