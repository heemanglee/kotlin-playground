package lec04

class Person private constructor(
    val name: String,
    val age: Int
) {

    /**
     * Java: static
     * Kotlin: companion object
     * companion object는 객체로 취급된다.
       즉, Person.Companion.newBaby("hope")로 호출할 수 있다.
     * 객체로 간주되기 때문에 이름을 붙이거나 interface를 구현할 수 있다.
       인터페이스가 아닌 클래스는 상속할 수 없다.
     */
    companion object : Temp{
        /**
         * const 사용: 컴파일 타임에 변수가 할당된다.
           기본 타입과 String 타입만 사용 가능하다.
         * const 사용x: 런타임 타임에 변수가 할당된다.
         */
        private const val MIN_AGE: Int = 1

        @JvmStatic
        fun newBaby(name: String) = Person(name, MIN_AGE)
    }
}

interface Temp

// 싱글톤으로 객체를 생성하기 위해서는 object 키워드를 사용한다.
object Singleton {
    val name = "Singleton"
}