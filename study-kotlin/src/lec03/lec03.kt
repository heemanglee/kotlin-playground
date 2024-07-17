package lec03

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    /**
     * Java : IOException(Checked-Exception) 예외가 발생하므로 예외 처리를 해주어야 한다.
     * Kotlin : 코틀린에서는 Checked-Exception과 Unchecked-Exception을 구분하지 않는다.
       즉, 코틀린에서는 모두 Unchecked-Exception이다.
     */
    var file = File("./lec03-lec03.txt")
    var reader = BufferedReader(FileReader(file))
    println(reader.readLine())


}

fun parseIntOrThrow(number: String): Int {
    try {
        return number.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 숫자 ${number}은 문자열입니다.")
    }
}

fun parseIntOrNull(number: String): Int? {
    return try {
        number.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}