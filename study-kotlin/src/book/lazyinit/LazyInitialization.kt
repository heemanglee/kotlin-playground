package book.lazyinit

class MutablePerson {
    // lateinit을 사용하기 위해서는 var 프로퍼티를 사용한다.
    lateinit var name: String
}

class ImmutablePerson {
    init {
        println("ImmutablePerson")
    }
    // by lazy를 사용하기 위해서는 val 프로파티를 사용한다.
    // name 프로퍼티를 호출하는 최초의 시점에 변수 초기화가 진행된다.
    // val 프로퍼티를 사용한 불변 프로퍼티이므로 세터를 가질 수 없다.
    val name: String by lazy {
        "test4"
    }
}

// 객체도 지연 초기화를 사용할 수 있다.
lateinit var person2: MutablePerson

val person4: ImmutablePerson by lazy {
    ImmutablePerson()
}

fun main() {
    val person1 = MutablePerson()
//    println(person.name) // 프로퍼티가 초기화되어 있지 않으므로 오류가 발생한다.

    person1.name = "test"
    println(person1.name) // test

    person1.name = "test2"
    println(person1.name) // test2

    person2 = MutablePerson()
    person2.name = "test3"
    println(person2.name) // test3

    val person3 = ImmutablePerson() // ImmutablePerson
    println(person3.name) // test4

    // person4의 프로퍼티를 사용하는 시점에 객체가 초기화된다.
    println(person4.name) // ImmutablePerson'\n' test4
}