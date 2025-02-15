package Kotlin_Task

import kotlin.random.Random

fun main() {
    val firstResult = Random.nextInt(6)
    val secondResult = Random.nextInt(6)

    println("First number: $firstResult")
    println("Second number: $secondResult")

    if (firstResult == secondResult) {
        println("You win")
    }
    else {
        println("You lose")
    }
}