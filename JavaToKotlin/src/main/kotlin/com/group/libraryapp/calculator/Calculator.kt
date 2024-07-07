package com.group.libraryapp.calculator

class Calculator(
    private var _number: Int
) {

    val number: Int
        get() = this._number

    fun add(num: Int) {
        this._number += num
    }

    fun minus(num: Int) {
        this._number -= num
    }

    fun multiply(num: Int) {
        this._number *= num
    }

    fun divide(num: Int) {
        if (num == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        this._number /= num
    }
}