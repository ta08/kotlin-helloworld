package com.example.spring_helloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * this controller can work... yeah!!!
 */
class HelloWorldController {

    @RestController
    class HelloWorldController {
        @GetMapping("/")
        fun helloWorld(): String {
            return "Hello World"
        }
    }
}