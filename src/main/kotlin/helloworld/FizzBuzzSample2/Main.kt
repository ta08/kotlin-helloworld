package org.example.helloworld.FizzBuzzSample2

fun main() {
    val n = 20
    for (i in 1..n) {
        println(org.example.helloworld.FizzBuzzSample1.fizzBuzz(i))
    }
}

fun fizzBuzz(i: Int): String {
    val result: String
    when {
        i % 15 == 0 -> {
            result = "FizzBuzz"
        }
        i % 3 == 0 -> {
            result = "Fizz"
        }
        i % 5 == 0 -> {
            result = "Buzz"
        }
        else -> {
            result = "$i"
        }
    }
    return result
}

fun fizzBuzz2(i: Int): String {
    return when {
        i % 15 == 0 -> {
            "FizzBuzz"
        }
        i % 3 == 0 -> {
            "Fizz"
        }
        i % 5 == 0 -> {
            "Buzz"
        }
        else -> {
            "$i"
        }
    }
}
