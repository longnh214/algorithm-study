fun main(){
    val num1 : Int? = 4
    val num2 : Long = num1?.toLong() ?: 0L// 타입 변환을 명시적으로 선언해야한다.
    val result : Double = (num1?.div(num2.toDouble()) ?: 0) as Double
    println(result)
}