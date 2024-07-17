package lec05

open class Train(
    private val name: String,
    private val _price: Int
) {

    //    fun price(): Int = this.price
    val price: Int
        get() = this._price
}