package lec01

fun main() {

    // 타입을 생략할 경우, 변수의 타입을 추론한다.
    var num1: Long = 10L
    val num2 = 10L

    /**
     * Java : long, Long을 구분한다. 즉, Primitive Type과 Wrapper Type을 구분한다.
     * Kotlin : Primitive Type과 Wrapper Type을 구분하지 않는다.
       프로그래머가 boxing, unboxing을 고려하지 않도록 자동으로 처리한다.
       boxing : Primitive -> Wrapper
       unboxing : Wrapper -> Primitive
     */
    val num3: Long = 10L

    // null 값을 저장하기 위해서는 "타입?"을 사용한다.
    val num4: Long ? = null

    // 객체 타입을 생성하기 위해서는 new 키워드를 사용하지 않는다.
    val person = Person("이희망")
    println(person.name)
}