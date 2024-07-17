package lec04

open class Base(
    open val number: Int = 100
) {

    init {
        println("Base Class")
        /**
         * 호출 순서 : init 블럭 -> 생성자
         * 따라서 init 블럭에서 number 프로퍼티에 접근하면 초기화되지 않은 초기값인 0을 갖게 된다.
         */
        println("Base Class number ${number}")
    }
}