package lec05

fun main() {
    /**
     * 배열 선언
     * Java : int[] array = new int[] { 100, 200 };
     * Kotlin : val array = arrayOf(100, 200)
     */
    val array = arrayOf(100, 200)
    for(i in array.indices) {
        println("idx : ${i}, value : ${array[i]}")
    }
    println("=====================================")

    /**
     * Kotlin에서 리스트를 생성할 때, 불변/가변을 지정해야한다.
     * listOf() : 불변 리스트
     * mutableListOf() : 가변 리스트
     */
    val immutableList = listOf(100, 200) // 불변 리스트
    val emptyList = emptyList<Int>() // 타입 추론을 할 수 없으므로 타입을 명시한다.
    /**
     * 리스트의 원소에 접근
     * Java : list.get(0)
     * Kotlin : list[0], list.get(0)
       또는 withIndex()를 사용하여 index와 value를 함께 가져올 수 있다.
     */
    println(immutableList[0])
    for((index, value) in immutableList.withIndex()) {
        println("index : ${index}, value = ${value}")
    }
    println("=====================================")

    /**
     * 가변 리스트 : mutableListOf()
     * 자바와 동일한 메서드를 제공한다.
     */
    val mutableList = mutableListOf(100, 200)
    mutableList.add(300) // 가변 리스트이므로 add()를 사용할 수 있다.
    for((index, value) in mutableList.withIndex()) {
        println("index : ${index}, value = ${value}")
    }
    println("=====================================")

    /**
     * Set을 생성할 때, 가변/불변을 지정해야한다.
     * 가변 : mutableSetOf()
     * 불변 : setOf()
     */
    val immutableSet = setOf(100, 200)
    for((index, value) in immutableSet.withIndex()) {
        println("index : ${index}, value : ${value}")
    }
    println("=====================================")

    val mutableSet = mutableSetOf(100, 200)
    mutableSet.add(300)
    for((index, value) in mutableSet.withIndex()) {
        println("index : ${index}, value : ${value}")
    }
    println("=====================================")

    /**
     * Map을 생성할 때, 불변/가변을 지정한다.
     * 불변 : mapOf()
     * 가변 : mutableMapOf()
     */
    val mutableMap = mutableMapOf(1 to "Mon", 2 to "TUE")
    mutableMap.put(3, "WED") // key가 3이면서 value가 "WED"인 원소를 추가한다.
    mutableMap[4] = "THU" // key가 4이면서 value가 "THU"인 원소를 추가한다.
    mutableMap.remove(4) // key가 4인 원소를 삭제한다.
    for((key, value) in mutableMap.entries) {
        println("key : ${key}, value : ${value}")
    }








}