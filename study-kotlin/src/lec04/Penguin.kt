package lec04

class Penguin(
    species: String
) : Animal(species, 2), Flyable, Swimmable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 날개 ${wingCount}개를 포함한 다리 ${legCount}개로 걸어간다.")
    }

    /**
     * 상위 클래스의 프로퍼리를 오버라이딩하기 위헤 override 키워드를 사용한다.
     * 단, 상위 클래스의 프로퍼티가 open 키워드로 선언되어 있어야 한다.
     */
    override val legCount: Int
        get() = super.legCount + this.wingCount


    /**
     * 상위 인터페이스의 메서드를 오버라이딩 하기 위해 super<터입>메서드() 형태로 사용한다.
     */
    override fun act() {
        super<Swimmable>.act()
        super<Flyable>.act()
    }
}