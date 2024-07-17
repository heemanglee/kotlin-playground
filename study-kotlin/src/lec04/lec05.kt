package lec04

import lec04.selaed.*

fun main() {
    // dto 클래스는 equals, hashcode, toString을 자동으로 적용한다.
    val dto = PersonDto("hope", 25)
    println(dto) // PersonDto(name=hope, age=25)

    // enum 클래스
    val country = CountryStatus.KOREA
    handleCountry(country)

    // sealed 클래스
    val car = Kia("k5", "white")
    car.carInfo();
    handleCar(car)
}

// 컴파일러가 enum의 모든 타입을 알고 있기 때문에 when절에서 else를 사용하지 않아도 된다.
fun handleCountry(country: CountryStatus) {
    when(country) {
        CountryStatus.KOREA -> println("한국입니다.")
        CountryStatus.AMERICA -> println("US입니다.")
    }
}

/**
 * sealed 클래스의 경우 컴파일 타임에 모든 하위 클래스를 알고 있다.
 * 따라서 when젏에서 else문을 사용하지 않아도 된다.
 * 그러나 sealed 클래스의 모든 하위 클스가 when 절에 포함되어야 한다.
   ex. 현재 sealed 클래스를 Hyundai, Kia, Hyonda 클래스가 상속하고 있는데,
        여기서 Honda 클래스를 when 절에서 제거하면 컴파일 오류가 발생한다.
        -> 'when' expression must be exhaustive, add necessary 'is Honda' branch or 'else' branch instead
 */
fun handleCar(car: Car) {
    when(car) {
        is Hyundai -> println("현대 자동차입니다.")
        is Kia -> println("기아 자동차입니다.")
        is Honda -> println("혼다 자동차입니다.")
    }
}