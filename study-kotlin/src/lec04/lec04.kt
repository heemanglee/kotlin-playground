package lec04

fun main() {
    val person = Person.newBaby("hope")
    println(person.name)
    println(person.age)

    println(Singleton.name)

    // 익명 클래스를 만들기 위해서 object 키워드를 사용한다.
    something(object : Movable {
        override fun move() {
            println("움직인다")
        }

        override fun fly() {
            println("날 수 있다")
        }
    })
}

fun something(movable: Movable){
    movable.move()
    movable.fly()
}