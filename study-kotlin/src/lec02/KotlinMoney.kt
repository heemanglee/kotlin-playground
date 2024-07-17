package lec02

class KotlinMoney (val money: Long) {
    // + 연산
    operator fun plus(other: KotlinMoney): KotlinMoney {
        return KotlinMoney(this.money + other.money)
    }

    override fun toString(): String {
        return money.toString()
    }


}