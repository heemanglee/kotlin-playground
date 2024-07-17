package lec03

fun main() {
    repeat("hello") // hello\n hello\n hello\n
    repeat("hello", 1) // hello\n
    repeat("hello", 2, false) // hellohello
    println()
    // 매개변수 이름을 사용하여 값을 직접 지정할 수 있다.
    repeat("hello", newLine = false) // hellohellohello
    println()

    printAll("1", "2", "3")
    val array: Array<String> = arrayOf("1", "2", "3")
    // 가변 인자에 배열을 넣기 위해서는 스프레드 연산자(*)를 사용한다.
    printAll(*array)

}


fun max1(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

// 반환 값이 1개라면 중괄호를 생략하고 "="를 사용할 수 있다.
fun max2(a: Int, b: Int): Int =
    if (a > b) {
        a
    } else {
        b
    }

// 메서드 반환 타입이 추론 가능한 경우에 아래와 같이 작성할 수 있다.
fun max3(a: Int, b: Int) = if (a > b) a else b

// 매개변수의 기본값을 지정할 수 있다.
fun repeat(str: String, num: Int = 3, newLine: Boolean = true) {
    for (i in 1..num) {
        if (newLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

/**
 * 매개변수로 가변 인자를 사용할 수 있다.
 * Java : printAll(String... strings)
 * Kotlin : printALl(vararg strings: String)
 */
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}