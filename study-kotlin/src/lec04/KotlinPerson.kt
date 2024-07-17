package lec04

/*
// 주생성자를 생성할 때 constructor 키워드를 생략할 수 있다.
class KotlinPerson(name: String, age: Int) {

    // 프로퍼티를 만들면 getter와 setter를 자동으로 생성한다.
    val name: String
    var age: Int

    // 생성자 호출 시점에 init 블록이 호출된다.
    init {
        if(age <= 0) {
            throw IllegalArgumentException("나이(${age})는 0보다 커야합니다.")
        }
        this.age = age
        this.name = name
    }

    // 코틀린에서는 1개의 주생성자와 N개의 부생성자를 생성할 수 있다.
    constructor(name: String): this(name, 1)
    constructor(): this("hope")
}
 */

/**
 * 부생성자를 여러 개 생성하는 것보단, default parameter하면 간결하고 가독성이 좋아진다.
 * default parameter 또는 정적 팩토리 메소드를 사용하는 것이 좋다.
 * name 필드가 val이지만 객체를 생성하는 시점에 생성자에의해 1회 변경이 가능하다.
 */
class KotlinPerson(val name: String = "hope", var age: Int = 25) {

    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이(${age})는 0보다 커야합니다.")
        }
    }

    // Custom Getter
    val isAdult: Boolean
        get() = this.age >= 20

    val upperName: String
        get() = this.name.uppercase()

    /*
     * (age + 1) 시점에 age의 getter를 호출하면서 무한루프에 빠진다.
     * 무한루프는 custum getter, setter를 사용하면서 발생한다.
    val backingFieldError: Int = age
        get() = age + 1
    */

    // "field"는 backing field에서 무한루프를 막기 위해 사용되고, 자기 자신을 가리킨다.
    val notBackingFieldError: Int = age
        get() = field + 1
    val notUseBackingField: Int
        get() = age + 1

    // "val" 변수에는 setter를 사용할 수 없다.

}