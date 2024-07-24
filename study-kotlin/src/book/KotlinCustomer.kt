package book

class KotlinCustomer {

    companion object {
        // const를 사용하면 컴파일 타임에 상수로 사용할 수 있다.
        // 자바에서 코틀린 companion object에 정의된 변수에 접근하기 위해서는 const가 붙어 있어야 한다.
        // 코틀린에서는 const가 붙지 않더라도 companion object에 정의된 변수에 바로 접근할 수 있다.
        const val NAME = "KotlinCustomer"

        @JvmStatic // 자바에서 코틀린의 companion object에 접근하기 위해서 사용하는 애너테이션
        fun call() {
            println("name = ${NAME}")
        }

        @JvmField // 자바에서 코틀린의 companion object에 정의된 변수에 접근할 수 있다.
        var name: String = "aa"
    }
}

fun main() {
    println(KotlinCustomer.NAME)
}