package lec03

fun main() {

    /**
     * Java : for(int number: numbers)
     * Kotlin : for(number in numbers)
     * "in" 뒤에는 iterator이 가능한 컬렋션이 온다.
     */
    val numbers = listOf(1, 2, 3)
    for(number in numbers){
        println(number)
    }
    for(index in 1..3) {
        println(index)
    }
    println()

    /**
     * Java : for(int index = 3; i >= 1; i--)
     * Kotlin : for(index in 3 downTo 1)
     */
    for(index in 3 downTo 1) {
        println(index)
    }
    println()

    /**
     * Java : for(int index = 1; i <= 5; i += 2)
     * Kotlin : for(index in 1..5 step 2)
     * "in"은 등차 수열을 만들어주낟.
     * "step"은 등차 수열의 공차를 지정한다.
     */
    for(index in 1..5 step 2) {
        println(index)
    }
}