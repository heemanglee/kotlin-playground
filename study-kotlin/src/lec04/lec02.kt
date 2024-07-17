package lec04

fun main() {
    val cat = Cat("cat")
    cat.move()
    val penguin = Penguin("penguin")
    penguin.move()
    penguin.act()
    println()

    val derived = Derived(1)
}