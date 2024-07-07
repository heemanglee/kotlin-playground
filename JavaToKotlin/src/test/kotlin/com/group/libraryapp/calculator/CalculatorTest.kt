package com.group.libraryapp.calculator

import net.bytebuddy.pool.TypePool.Resolution.Illegal

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
    calculatorTest.dividedTest()
    calculatorTest.divideExceptionTest()
}

class CalculatorTest {

    fun addTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.add(3)

        //then
        if (calculator.number != 8) {
            throw IllegalArgumentException()
        }
    }

    fun minusTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.minus(3)

        //then
        if (calculator.number != 2) {
            throw IllegalArgumentException()
        }
    }

    fun multiplyTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.multiply(3)

        //then
        if (calculator.number != 15) {
            throw IllegalArgumentException()
        }
    }

    fun dividedTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.divide(2)

        //then
        if (calculator.number != 2) {
            throw IllegalArgumentException()
        }
    }

    fun divideExceptionTest() {
        //given
        val calculator = Calculator(5)

        //when
        try {
            calculator.divide(0)
        } catch(e: IllegalArgumentException) {
            if(e.message != "0으로 나눌 수 없습니다.") {
                throw IllegalArgumentException()
            }
            return // 테스트 성공
        }

        // 테스트 실패
        throw IllegalArgumentException("기대하는 예외가 발생하지 않았습니다.")
    }

}