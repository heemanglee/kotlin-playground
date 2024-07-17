package lec04

class Derived(
    override val number: Int
): Base(number) {

    init {
        println("Derived Class")
        println("Derived Class number : ${number}")
    }
}