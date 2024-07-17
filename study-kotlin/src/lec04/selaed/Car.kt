package lec04.selaed


/**
 * sealed 클래스는 상속을 제한한다.
 * sealed 클래스는 같은 패키지의 자식만 상속이 가능하다.
 * 컴파일 타임에 sealed 클래스의 모든 하위 클래스를 알고 있으므로, 런타임 때 새로운 클래스 타입이 추가될 수 없다.
 */
sealed class Car(
    val name: String,
    val color: String
) {

    internal fun carInfo() {
        println("차의 종류는 ${name}이며 색깔은 ${color}입니다.")
    }
}