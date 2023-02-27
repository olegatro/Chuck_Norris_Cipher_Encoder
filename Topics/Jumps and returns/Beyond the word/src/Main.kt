fun main() {
    val input = readln().split("")
    val list: MutableList<String> = mutableListOf()

    for (alphabetLetter in 'a'..'z') {
        var hasMatch: Boolean = false

        for (symbol in input) {
            if (alphabetLetter.toString() == symbol) {
                hasMatch = true
            }
        }

        if (!hasMatch) {
            list.add(alphabetLetter.toString())
        }
    }

    println(list.joinToString(""))
}
