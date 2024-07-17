package lec04

/**
 * Java : extends
 * Kotlin : : (콜론)

 */
class Cat(
    species: String
) : Animal(species, 4) {

    // 추상 메소드를 구현할 때는 override 키워드를 사용해야 한다.
    override fun move() {
        println("고양이가 ${legCount}개수의 다리로 걸어간다.")
    }
}