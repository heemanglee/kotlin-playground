package lec05

fun main() {
    val str = "hope"
    println(str.lastChar()) // lastChar() : 확장 함수

    /**
     * Person 클래스에 nextYearAge() 함수가 존재한다.
     * 만약 멤버함수와 확장함수의 시그니처가 같다면, 멤버함수가 우선적으로 호출된다.
     */
    val person = Person("이희망", 25)
    // 멤버 함수 호출
    // 출력 : 26
    println(person.nextYearAge())

    /**
     * 확장 함수가 오버라이드된 경우 인스턴스 타입의 확장 함수가 호출된다.
     */
    val train = Train("train", 10000)
    println(train.isExpensive()) // true
    val ktx = Ktx("ktx", 10000)
    println(ktx.isExpensive()) // false
    val ktx2 = Train("ktx2", 10000)
    println(ktx2.isExpensive()) // true

    /**
     * 중위 함수 (infix)
     * 변수.함수이름(인자) -> 변수 함수이름 인자
     * ex) step, downTo
     */
    println(3 add 5) // 8
}

fun Person.nextYearAge(): Int {
    println("확장 함수 호출")
    return this.age + 2
}

fun Train.isExpensive(): Boolean {
    return this.price >= 10000
}

fun Ktx.isExpensive(): Boolean {
    return this.price >= 12000
}

// 중위 함수를 사용하기 위해 infix 키워드를 사용한다.
infix fun Int.add(num: Int): Int {
    return this + num
}

/**
 * 지역함수
 * 지역함수를 사용하면 depth가 깊어지므로 따로 빼내는 것이 좋을 것 같다.
 */
fun createPerson(name: String, age: Int): Person {
    fun validatePerson(name: String, age: Int) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("이름이 비어있습니다.")
        }
        if (age == 0) {
            throw IllegalArgumentException("나이가 0살입니다.")
        }
    }

    validatePerson(name, age)
    return Person(name, age)
}
