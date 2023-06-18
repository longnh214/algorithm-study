fun main() {
    if(fun1() || fun2()){ //fun1()이 참이면 fun2()를 실행하지 않는다. = Lazy 연산
        println("본문 실행.")
    }
}

fun fun1(): Boolean{
    println("fun 1")
    return true
}

fun fun2(): Boolean{
    println("fun 2")
    return false
}