fun main() {
    val (hour, minute, second) = readln().split(' ')
    val (day, month, year) = readln().split(' ')

    println("$hour:$minute:$second $day/$month/$year")
}