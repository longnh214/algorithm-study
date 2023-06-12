fun main() {
    val str: String? = "ABC"
    //println(str.length) // 불가능 Null이 들어갈 수 있는 변수에 대해서는 .을 바로 쓸 수 없다.
    println(str?.length) // 가능 (Elvis 연산자 : str이 null이 아니면 실행하고, null이면 실행하지 않는다(그대로 null을 반환)는 의미.) / Safe Call

    // Elvis 연산자
    val str1 : String? = null
    println(str1?.length ?: 0) // 삼항 연산자 느낌...? str1이 null이면 0을 반환.
}