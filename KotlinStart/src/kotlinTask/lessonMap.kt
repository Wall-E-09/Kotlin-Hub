package kotlinTask

val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)

val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)

val juiceMenuLocked: Map<String, Int> = juiceMenu

fun main(){
    println(readOnlyJuiceMenu)
    println(juiceMenu)
    println("Juice menu price of apple: ${juiceMenu["apple"]}")
    println("Is juice menu empty? ${juiceMenuLocked.isEmpty()}")
    juiceMenu["kiwi"] = 200
    println(juiceMenu)
}