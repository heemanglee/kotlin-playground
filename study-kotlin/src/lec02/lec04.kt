package lec02

fun main() {
    var num1 = 1_000
    var num2 = 2_000

    // Primitive Type의 연산자는 Java와 동일하다.
    println(num1 + num2)
    println(num1 - num2)
    println(num1 * num2)
    println(num1 / num2)
    println(num1 % num2)
    println(num1++)
    println(--num1)
    println(num1 > num2)
    println()


    /***
     * Reference Type의 연산자는 Java와 동일하지 않다.
     * 코틀린에서는 객체를 비교할 시에 compareTo()를 통해 비교한다.
       compareTo()가 구현되어 있지 않으면 컴파일 오류가 발생한다.
     */
    val money1 = JavaMoney(1_000)
    val money2 = JavaMoney(2_000)
    println(money1 > money2)
    println()

    /**
     * 코틀린은 자바와 동일성, 동등성 비교 방식이 다르다.
     * Java : 동일성 비교 -> "==", 동등성 비교 : "equals()"
     * Kotlin : 동일성 비교 -> "===", 동등성 비교 : "=="
       단, "=="는 equals()를 호출하기 떄문에, 클래스에 "equals()"를 구현해야 한다.
       구현하지 않은 상태로 "=="를 통해 동등성 비교를 하면 false를 반환한다.
     */
    val m1 = JavaMoney(1_000)
    val m2 = JavaMoney(1_000)
    val m3 = m1
    val money3 = money1
    println(m1 == m2) // true
    println(m1 == m3) // true
    println(m2 ==  m3) // true
    println(m1 === m2) // false
    println(m1 === m3) // true
    println(m2 === m3) // false
    println()


     // 코틀린은 자바와 동일하게 Lazy 연산을 수행한다/
    if(returnTrue() || returnFalse()) {
        // returnTrue()만 호출된다.
    }
    if(returnFalse() && returnTrue()) {
        // returnFalse()만 호출한다.
    }
    println()

    /**
     * 코틀린은 연산자 오버로딩을 지원한다.
     */
    val kMoney1 = KotlinMoney(1_000)
    val kMoney2 = KotlinMoney(2_000)
    println(kMoney1 + kMoney2) // 3000

}

fun returnFalse(): Boolean {
    println("false 호출")
    return false
}
fun returnTrue(): Boolean {
    println("true 호출")
    return true
}