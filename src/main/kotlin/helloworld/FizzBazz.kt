package org.example.helloworld

fun main() {
    val n = 20
    for (i in 1..n) {
        println(fizzBuzz(i))
    }
}

//冗長に書いたパターン
fun fizzBuzz(i: Int): String {
    val result: String
    if (i % 15 == 0) {
        result = "FizzBuzz"
    } else if (i % 3 == 0) {
        result = "Fizz"
    } else if (i % 5 == 0) {
        result = "Buzz"
    } else {
        result = "$i"
    }

    return result
}


// 早期 return にしたパターン
fun fizzBuzz2(i: Int): String {
    if (i % 15 == 0) {
        return "FizzBuzz"
    } else if (i % 3 == 0) {
        return "Fizz"
    } else if (i % 5 == 0) {
        return "Buzz"
    } else {
        return "$i"
    }
}


//if 式の結果を変数に代入したパターン
fun fizzBuzz3(i: Int): String {
    val result = if (i % 15 == 0) {
        "FizzBuzz"
    } else if (i % 3 == 0) {
        "Fizz"
    } else if (i % 5 == 0) {
        "Buzz"
    } else {
        "$i"
    }
    return result
}
