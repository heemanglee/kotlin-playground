package lec02

import lec01.Person

fun main() {
    var number1: Int = 4
    // val number2: Long = number1 -> 코틀린에서는 묵시적 타입 변환이 불가능하다.
    var number2: Long = number1.toLong() // to변환타입()을 명시적으로 표현한다.

    var person: Person = Person("hope")
    printAgeIfPerson(person)

    var notPerson: Int = 10
    isPerson(person) // obj의 타입은 Person이다.
    isPerson(notPerson) // obj 타입은 Person이 아니다.

    // nullValueTypeCasting(null) ->  java.lang.NullPointerException
    println(nullValueTypeCasting(person)) // lec01.Person@7d417077
    println(nulValueTypeCasting2(null)) // null
    println(nulValueTypeCasting2(notPerson)) // null

    /**
     * 문자열의 문자를 가져오기 위해서 배열에 접근하듯이 인덱스를 사용한다.
     * Java : str.charAt(0)
     * Kotlin : str[0]
     */
    var str: String = "hope"
    println(str[0]) // 'h'
}

/**
 * Java : instanceof, 타입 캐스팅 : (Person) obj
 * Kotlin : is, 타입 캐스팅 : obj as Person
 */
fun printAgeIfPerson(obj: Any) {
//    var person: Person = obj
    if(obj is Person) {
        // if문을 통해 타입 체크를 했기 때문에 "as Person"을 생략해도 된다.
        val person: Person = obj as Person
        println(person.name)
    }
}

fun isPerson(obj: Any) {
    if(obj is Person) {
        println("obj의 타입은 Person이다.")
    }
    else if(obj !is Person) {
        println("obj 타입은 Person이 아니다.")
    }
}

/**
 * "as"를 통해 타입 캐스팅 시, obj가 null이면 NPE를 발생한다.
 * obj가 null 아니면 타입 변환된다.
 */
fun nullValueTypeCasting(obj: Any?): Person {
    return obj as Person
}

/**
 * "as?" 타입 캐스팅 시, obj가 null이면 null을 반환한다.
 * obj가 Person 타입이 아니면 null을 반환한다.
 */
fun nulValueTypeCasting2(obj: Any?): Person? {
    return obj as? Person
}