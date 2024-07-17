package lec05

/**
 * 확장 함수
 * fun : 함수
 * String : 확장할 클래스
 * lastChar : 함수 이름
 * this를 사용하여 실제 클래스 안의 값에 접근
 * 수신 객체 : this
 * 수신 객체 타입 : String
 */
fun String.lastChar() : Char {
    return this[this.length -1]
}