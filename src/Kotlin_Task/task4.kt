package Kotlin_Task

fun main() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = "smtp" in SUPPORTED
        println("Support for $requested: $isSupported")
}