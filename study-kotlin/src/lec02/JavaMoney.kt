package lec02

import java.util.*

class JavaMoney(private val amount: Long) : Comparable<JavaMoney> {
    override fun compareTo(other: JavaMoney): Int {
        return java.lang.Long.compare(this.amount, other.amount)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val money = o as JavaMoney
        return amount == money.amount
    }

    override fun hashCode(): Int {
        return Objects.hashCode(amount)
    }
}
