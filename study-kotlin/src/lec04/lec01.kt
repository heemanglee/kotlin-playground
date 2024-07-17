package lec04

fun main() {
    val person = KotlinPerson("hope", 25)

    /**
     * Kotlin에서는 필드로 접근하여 getter와 setter를 호출할 수 있다.
     */
    println(person.name)
    person.age = 25
    println(person.age)
    println()

    println(person.isAdult)
    println(person.upperName)

}