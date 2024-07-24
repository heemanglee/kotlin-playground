package book.`property-override`

// open : 하위 클래스가 해당 클래스를 상속 가능
open class First(
    _x: Int,
    _y: Int
) {

    // open : 하위 클래스에서 오버라이딩 가능
    open val x: Int = _x
        get() {
            println("First x : ${field}")
            return field
        }
    val y: Int = _y
        get() {
            println("First y : ${field}")
            return field
        }
}

class Second(
    _x: Int,
    _y: Int
) : First(_x, _y) {

    override val x: Int = _x
        get() {
            println("Second x : ${field}")
            return field
        }

    // y 프로퍼티는 open을 사용하지 않았기 때문에 final 변수이다.
}

fun main() {
    val second = Second(1, 2)
    println("Second x : ${second.x}, y : ${second.y}")

    // 출력
    /**
        Second x : 1
        First y : 2
        Second x : 1, y : 2
     */
}