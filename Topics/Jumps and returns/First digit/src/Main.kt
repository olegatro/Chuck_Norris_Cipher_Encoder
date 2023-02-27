fun main() {
    val input = readln()

    for (symbol in input) {
        if (symbol.toString() in "0".."9") {
            println(symbol)
            break
        }
    }
}