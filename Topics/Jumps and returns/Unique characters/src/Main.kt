fun main() {
    val input: String = readln()
    var uniqueCount: Int = 0

    for (i in input.indices) {
        var isUnique = true

        for (j in input.indices) {
            if (i == j) continue
            if (input[i] == input[j]) {
                isUnique = false
                break
            }
        }

        if (isUnique) uniqueCount++
    }

    println(uniqueCount)
}