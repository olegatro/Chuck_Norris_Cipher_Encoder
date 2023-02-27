fun main() {
    val dayCount: Int = readln().toInt()
    val foodCost: Int = readln().toInt()
    val flightCost: Int = readln().toInt()
    val oneNightCost: Int = readln().toInt()

    val result: Int = (dayCount * foodCost) + (flightCost * 2) + ((dayCount - 1) * oneNightCost)

    println(result)
}