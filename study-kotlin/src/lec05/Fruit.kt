package lec05

class Fruit(
    private val _name: String) {

    val name: String
        get() = this._name
}