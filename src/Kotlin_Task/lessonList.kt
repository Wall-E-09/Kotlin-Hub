package Kotlin_Task

val readOnlyShape = listOf("triangle", "square", "circle")

val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")

val shapesLocked: List<String> = shapes


fun main() {
    println(readOnlyShape)
    println(shapes)
    println("Number of shapes before adding: ${shapes.count()}")
    shapes.add("pentagon")
    println(shapes)
    println("Number of shapes after adding: ${shapes.size}")
    if ("square" in shapes){
        println("Square is in the list")
    }
    else println("Square is not in the list")
    /*shapesLocked.add("hexagon")
    println(shapesLocked)*/
    println("First element of readOnlyShape is ${readOnlyShape[0]}")
    println("First element of readOnlyShape is ${readOnlyShape.first()}")
    println("Last element of readOnlyShape is ${readOnlyShape.last()}")
    println("Last element of readOnlyShape is ${readOnlyShape[readOnlyShape.size - 1]}")

}