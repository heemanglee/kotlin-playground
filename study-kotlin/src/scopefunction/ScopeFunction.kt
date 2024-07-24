package scopefunction

data class Book(
    var name: String,
    var price: Int
) {

    fun discountPrice() {
        this.price -= 2000
    }

    fun increasePrice() {
        this.price += 2000

    }
}

fun main() {

    // fun <T> T.apply(block : T.() -> Unit): T
    // 인스턴스를 생성하고 특정 변수에 할당하기 전에 초기화 작업을 수행하는데 사용한다.
    // ex. book1에 Book 인스턴스를 할당하기 전에 apply를 사용하여 초기회 작업을 먼저 수행한다.
    val book1 = Book("자바 ORM 표준 JPA 프로그래밍", 43000).apply {
        name = "[세일 중]" + this.name
        discountPrice()
    }
    // 책 제목 : [세일 중]자바 ORM 표준 JPA 프로그래밍, 책 가격 : 41000
    println("책 제목 : ${book1.name}, 할인된 가격 : ${book1.price}")


    // --------------------------------------------------------------------------


    // fun <T,R> T.run(block : T.() -> R) : R
    // 기존의 인스턴스를 사용하여 필요로 하는 값을 반환하는데 사용한다.
    // ex. book1의 경우 할인된 가격으로 판매 중이지만, 할인을 중단한다.
    val originalBookPrice = book1.run {
        name = name.substring(name.indexOf("]") + 1)
        increasePrice()
        book1.price // 실제로 반환하는 값 -> originalBookPrice에 저장된다.
    }
    // 책 제목 : [세일 중]자바 ORM 표준 JPA 프로그래밍, 책 가격 : 43000
    println("책 제목 : ${book1.name}, 원래 가격 : ${originalBookPrice}")


    // --------------------------------------------------------------------------


    // fun <T, R> with(receiver : T, block: T.() -> R) : R
    // run과 with는 형태가 매우 비슷한데, 차이점이라곤 receiver 객체를 인자로 받는 가의 여부이다.
    var discountBook = with(book1) {
        discountPrice()
        name = "[세일 중]" + name
        book1 // book1 객체를 반환한다.
    }
    // 책 제목 : [세일 중]자바 ORM 표준 JPA 프로그래밍, 할인된 가격 : 41000
    println("책 제목 : ${discountBook.name}, 할인된 가격 : ${discountBook.price}")


    // --------------------------------------------------------------------------


    // fun <T> T.also(block: (T) -> Unit) : T
    // fun<T,R> T.let(block : (T) -> R) : R
    // 공통적으로 it을 사용하여 프로퍼티에 접근할 수 있다.
    var price = 0
    book1.run {
        // 책 제목 : [세일 중]자바 ORM 표준 JPA 프로그래밍, 할인된 가격 : 0
        // name 프로퍼티는 book1 객체의 name 프로퍼티를 사용하고 있으나, price는 book1 객체가 아닌 상위 스코프(현재는 main 스코프)에 선언된 price를 사용한다.
        println("책 제목 : ${name}, 할인된 가격 : ${price}")
    }

    book1.also {
        // 책 제목 : [세일 중]자바 ORM 표준 JPA 프로그래밍, 할인된 가격 : 41000
        // also의 경우 it을 사용할 수 있다.
        println("책 제목 : ${it.name}, 할인된 가격 : ${it.price}")
    }
    book1.let {
        // 책 제목 : [세일 중]자바 ORM 표준 JPA 프로그래밍, 할인된 가격 : 41000
        // let 또한 it을 사용할 수 있다.
        println("책 제목 : ${it.name}, 할인된 가격 : ${it.price}")
    }

}