package book.`backing-field`

class BackingField (
    _id: Int,
    _name: String,
    _age: Int
) {

    // val 변수는 불변이므로 세터를 생성할 수 없다.
    val id: Int = _id
        get() = field

    // field : 프로퍼티를 참조하는 보조 필드(backing field)
    // 프로퍼티 : 자바의 변수와 달리, 코틀린은 val 변수에 대해서 게터를 생성하고 var 변수에 대해서는 게터와 세터 둘 다 생성한다.
    var name: String = _name
        // field(backing field)를 사용하여 프로퍼티에 값을 저장한다.
        // get() = name 으로 작성한다면, name 프로퍼티의 게터를 다시 호출하기 때문에 StackOverflow가 발생한다. -> Java : this.getName()
        // 따라서 backing field를 사용한다. -> Kotlin : this.age 으로 변환되기 때문에 게터를 다시 호출하는 것이 아닌, 변수를 직접 반환한다.
        get() = field
        // name = value1 으로 작성한다면, name에 value1을 저장하기 위해 name의 세터를 다시 호출하기 때문에 StackOverflow가 발생한다. -> Java : this.setName(value1)
        // 따라서 backing field를 사용한다. -> Kotiln : this.name = value1 으로 변환되기 떄문에 세터를 다시 호출하는 것이 아닌, 변수에 직접 값을 할당한다.
        set(value1) {
            field= value1
        }

    var age: Int = _age
        get() = field
        set(value2) {
            field= value2
        }

}

fun main() {
    val b1 = BackingField(1, "test1", 99)
    b1.name = "test"
    b1.age = 100

    println("name : ${b1.name}, age : ${b1.age}") // 출력 : name : test, age : 100
}