package lec04

interface Swimmable {

    /**
     * 코틀린에서는 default 키워드 없이 메소드 구현 가능하다.
     * Java : default void act()
     * Kotlin : fun act()
     */
    fun act() {
        println("어푸 어푸")
    }
}