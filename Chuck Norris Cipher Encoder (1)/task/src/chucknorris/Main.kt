package chucknorris

import kotlin.math.pow

fun convertFromDecimalToBinary(input: Int): String {
    val list: MutableList<Int> = mutableListOf()
    var result: Int = input

    while (result != 0) {
        list.add(result % 2)
        result /= 2
    }

    while (list.size < 7) {
        list.add(0)
    }

    return list.asReversed().joinToString("")
}

fun convertFromBinaryToDecimal(input: String): Int {
    var result: Double = 0.0
    var index: Int = 0

    for (symbol in input.reversed()) {
        result += symbol.toString().toDouble() * 2.0.pow(index)

        index++
    }

    return result.toInt()
}

fun convertFromStringToBinary(string: String): String {
    var binaryString: String = ""
    val resultList: MutableList<String> = mutableListOf()
    var index: Int = 0

    for (symbol in string) {
        binaryString += convertFromDecimalToBinary(symbol.code)
    }

    do {
        resultList.add(if (binaryString[index].toString() == "1") "0" else "00")

        val nextSymbol: String = if (binaryString[index].toString() == "1") "0" else "1"
        val nextIndex: Int = binaryString.indexOf(nextSymbol, index)

        if (nextIndex != -1) {
            resultList.add("0".repeat(nextIndex - index))
        } else {
            resultList.add("0".repeat(binaryString.lastIndex - index + 1))
            break
        }

        index = nextIndex
    } while (true)

    return resultList.joinToString(" ")
}

fun convertFromBinaryToString(input: String): String {
    val inputList: MutableList<String> = mutableListOf()
    val resultList: MutableList<Char> = mutableListOf()

    do {
        val startIndex: Int = inputList.size * 7
        val endIndex: Int = startIndex + 7 - 1

        inputList.add(input.slice(startIndex..endIndex))
    } while (inputList.size < input.length / 7)

    for (element in inputList) {
        resultList.add(convertFromBinaryToDecimal(element).toChar())
    }

    return resultList.joinToString("")
}

fun isValidEncode(input: String): Boolean {
    val inputList: List<String> = input.split(" ")
    var index: Int = 0

    // The encoded message includes characters other than 0 or spaces
    for (symbol in input) {
        if (symbol.toString() != "0" && symbol.toString() != " ") return false
    }

    // The first block of each sequence is not 0 or 00
    do {
        if (inputList[index] != "0" && inputList[index] != "00") return false

        index += 2
    } while (index < inputList.lastIndex)

    // The number of blocks is odd
    if (inputList.size % 2 != 0) return false

    // The length of the decoded binary string is not a multiple of 7
    index = 0
    val binaryList: MutableList<String> = mutableListOf()

    do {
        val symbol = if (inputList[index] == "0") "1" else "0"

        binaryList.add(symbol.repeat(inputList[index + 1].length))

        index += 2
    } while (index < inputList.lastIndex)

    if (binaryList.joinToString("").length % 7 != 0) return false

    return true
}

fun decode() {
    println("Input encoded string:")

    val input: String = readln()

    if (!isValidEncode(input)) {
        println("Encoded string is not valid.")
        return
    }

    val inputList: List<String> = input.split(" ")
    val binaryList: MutableList<String> = mutableListOf()
    var index: Int = 0

    do {
        val symbol = if (inputList[index] == "0") "1" else "0"

        binaryList.add(symbol.repeat(inputList[index + 1].length))

        index += 2
    } while (index < inputList.lastIndex)

    println("Decoded string:")
    println(convertFromBinaryToString(binaryList.joinToString("")))
}

fun encode() {
    println("Input string:")

    val input: String = readln()

    println("Encoded string:")
    println(convertFromStringToBinary(input))
}

fun menu() {
    while (true) {
        println("Please input operation (encode/decode/exit):")
        val input: String = readln()

        when (input) {
            "encode" -> encode()
            "decode" -> decode()
            "exit" -> break
            else -> println("There is no '$input' operation")
        }
    }

    println("Bye!")
}

fun main() {
    menu()
}