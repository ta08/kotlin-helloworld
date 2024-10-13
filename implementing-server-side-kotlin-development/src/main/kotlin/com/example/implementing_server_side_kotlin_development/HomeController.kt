package com.example.implementing_server_side_kotlin_development

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping("/")
    fun index():String{
        return "Hello World"
    }
}