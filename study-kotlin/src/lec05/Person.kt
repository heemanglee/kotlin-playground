package lec05

class Person(
    private val nane: String,
    private val _age: Int
) {

    fun nextYearAge(): Int = this.age + 1
    val age: Int
        get() = this._age
}