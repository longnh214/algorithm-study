fun main(){
//    var number1 // var이지만 값을 할당해주지 않았기 때문에 에러.
    var number1 : Long // 값을 할당해주지 않았지만, Type을 명시해주면, 에러가 사라진다.
    // println(number1) // 값이 할당되지 않은 변수를 사용(print)하려하면 에러.
    number1 = 10L
    println(number1) // 값을 할당하면 실행된다.

//    val number2 // val도 값을 할당해주지 않았기 때문에 에러.
    val number2 : Long // val도 값을 할당해주지 않았지만, Type을 명시해주면, 에러가 사라진다.
//    println(number2) // 값이 할당되지 않은 변수를 사용(print)하려하면 에러.
    number2 = 20L // val은 한 번만 값을 할당할 수 있고, 불변이지만, 최초 한 번 값 할당이 가능하다.
    println(number2) // 값을 할당하면 실행된다.

    // 코틀린에서 모든 변수는 우선 val로 만들고 꼭 필요한 경우에 var를 사용한다.
}