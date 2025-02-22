package kotlinTask

val readOnlyFruit = setOf("Apple", "Banana", "Orange", "Orange")

val fruit: MutableSet<String> = mutableSetOf("Apple", "Banana", "Orange", "Orange")
val fruitLocked: Set<String> = fruit

fun main(){
    println(readOnlyFruit)
    println(fruit)
    println("Items in set (fruitLocked): ${fruitLocked.count()}")
    println("Banana" in fruit)
    println("Is set empty? ${fruitLocked.isEmpty()}")
    fruit.add("Dragon fruit")
    println(fruit)
    fruit.remove("Apple")
    println(fruit)
}