package chucknorris

fun main() {
    println("Input string:")

    val stringList: List<String> = readln().split("")

    println(stringList.joinToString(" "))
}