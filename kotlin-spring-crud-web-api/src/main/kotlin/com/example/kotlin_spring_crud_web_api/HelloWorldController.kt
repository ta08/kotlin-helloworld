package com.example.kotlin_spring_crud_web_api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    @GetMapping("/")
    fun helloWorld(): String {
        return "Hello World"
    }
}
