package lec02

fun startsWithOld1(str: String?): Boolean {
    // 함수 반환 타입이 Boolean이므로 null을 반환할 수 없다.
    if (str == null) {
        throw IllegalArgumentException("str is null")
    }
    // 위에서 null 체크를 했기 때문에, "?."를 사용하지 않더라도 컴파일 에러가 발생하지 않는다.
    return str.startsWith("A")
}
fun startsWithNew1(str: String?): Boolean {
    // Safe Call -> "?." 연산자를 사용하여 null 체크를 한다.
    // Elvis Operator -> "?:" 연산자를 사용하여 null일 경우, 예외를 발생시킨다.
    return str?.startsWith("A") ?: throw IllegalArgumentException("str is null")
}

fun startsWithOld2(str: String?): Boolean? {
    if (str == null) {
        return null;
    }
    return str.startsWith("A")
}
fun startsWithNew2(str: String?): Boolean? {
    return str?.startsWith("A") ?: null
}

fun startsWith3(str: String?): Boolean {
    if (str == null) {
        return false
    }
    return str.startsWith("A")
}
fun startsWithNew3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

/**
 * "!!" 연산자를 사용하여 null이 아님을 단언한다.
 * 반드시 null 값이 들어오지 않는 경우에만 사용한다.
   null 값이 들어올 경우 NPE가 발생한다.
 */
fun startsWithA(str: String?): Boolean {
    return str!!.startsWith("A")
}