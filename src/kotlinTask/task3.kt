package kotlinTask

fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)

    val greenSize = greenNumbers.size
    val redSize = redNumbers.size
    val totalSize = greenSize + redSize
    println("Number of green elements: $greenSize")
    println("Number of red elements: $redSize")
    println("Total number of elements: $totalSize")
    
}