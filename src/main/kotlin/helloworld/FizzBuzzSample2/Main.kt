package org.example.helloworld.FizzBuzzSample2

fun main() {
    val n = 20
    for (i in 1..n) {
        println(fizzBuzz(i))
    }

    IntRange(1, n).map(::fizzBuzz2).forEach(::println)


//    Scala syntax....
//    val printFizzBuzz = ::fizzBuzz3 andThen ::println
//    IntRange(1,n).forEach {printFizzBuzz}

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

fun fizzBuzz3(i: Int): String {
    return when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }
}

