package com.group.libraryapp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class JUnit5CalculatorTest {

    @Test
    fun addTest() {
        // given5
        val calculator = Calculator(5)

        // when
        calculator.add(5)

        // then
        assertThat(calculator.number).isEqualTo(10)
    }

    @Test
    fun minusTest() {
        // given5
        val calculator = Calculator(5)

        // when
        calculator.minus(5)

        // then
        assertThat(calculator.number).isEqualTo(0)
    }

    @Test
    fun multiplyTest() {
        // given5
        val calculator = Calculator(5)

        // when
        calculator.multiply(5)

        // then
        assertThat(calculator.number).isEqualTo(25)
    }

    @Test
    fun divideTest() {
        // given5
        val calculator = Calculator(5)

        // when
        calculator.divide(5)

        // then
        assertThat(calculator.number).isEqualTo(1)
    }

    @Test
    fun divideExceptionTest() {
        // given5
        val calculator = Calculator(5)

        // when, then
        val message = assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }.message

        assertThat(message).isEqualTo("0으로 나눌 수 없습니다.")
    }

}