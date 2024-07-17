package lec05

/**
 * Java : 2급 시민
 * Kotlin : 1급 시민
 * 1급 시민 : 함수를 변수에 담을 수 있다.
 * 아래는 변수에 람다 함수를 할당하는 예시
 */
val isApple = fun(fruit: Fruit): Boolean {
    return fruit.name == "사과"
}
val isApple2 = { fruit:Fruit -> fruit.name == "사과"}

fun main() {
    val apple = Fruit("사과")
    val notApple = Fruit("바나나")
    println(isApple(apple)) // true
    println(isApple(notApple)) // false

    // 함수 타입 : (파라미터 타입) -> 반환 타입
    val fruit: (Fruit) -> Boolean
            = fun(fruit: Fruit): Boolean
            { return fruit.name == "사과" }
    val fruit2: (Fruit) -> Boolean = {
        fruit -> fruit.name == "사과"
    }

    val fruits = listOf(apple, notApple)
    // 람다의 파라미터가 1개인 경우 it 사용 가능 -> it은 지양하는게 좋다.
    // 함수 파라미터가 함수인 경우 소괄호() 밖에 람다 사용 가능{}
    val result = getApples(fruits) { fruit -> fruit.name == "사과" }
    for(fruit in result) {
        println(fruit.name)
    }
}

fun getApples(fruits: List<Fruit>, filter: (Fruit) -> Boolean) : List<Fruit> {
    val results = mutableListOf<Fruit>()
    for(fruit in fruits) {
        if(filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}