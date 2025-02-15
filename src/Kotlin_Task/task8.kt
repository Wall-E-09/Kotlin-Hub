package Kotlin_Task

var pizzaSlices = 1
var pizzaSlices2 = 1
fun main(){
    while (pizzaSlices < 8) {
        println("There's only $pizzaSlices slice/s of pizza :(")
        pizzaSlices++
    }
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")

    doWhile()
}

fun doWhile() {
    do{
        println("There's only $pizzaSlices2 slice/s of pizza :(")
        pizzaSlices2++
    } while (pizzaSlices2 < 8)

    println("There are $pizzaSlices2 slices of pizza. Hooray! We have a whole pizza! :D")
}