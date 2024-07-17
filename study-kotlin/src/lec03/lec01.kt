package lec03


/**
 * Java : if-else는 Statement이다. statement : 프로그램의 문장
   score >= 50 ? true : false
 * Kotlin : if-else는 Expression이다. expression : 결과를 반환하는 식
   Kotlin은 삼항 연산자가 존재하지 않는다.
 */
fun validateScoreIsGreaterThan50(score: Int): Boolean {
    return if (score >= 50) {
        true
    } else {
        false
    }
}

/**
 * Java : if(0 <= score && score <= 100)
 * Kotlin : "in A..B"을 사용하여 between 범위 지정
 */
fun validateScoreBetween0And100(score: Int): Boolean {
    return score in 0..100
}

/**
 * Java : switch-case
 * Kotlin : when
 */
fun getGrade(score: Int): String {
    return when(score) {
        100 -> "A+"
        in 90..99 -> "A"
        in 80..89 -> "B+"
        else -> "B"
    }
}

/**
 * Java : if(score == 0 || score == 1 || score == 2)
 */
fun validateScoreIs0or1or2(score: Int): Boolean {
    return when(score) {
        0, 1, 2 -> true
        else -> false
    }
}