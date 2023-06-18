fun main() {
    val money = KotlinMoney(1000L)
    val money2 = KotlinMoney(2000L)

    println(money + money2)
}

data class KotlinMoney(
       val value: Long
){
    operator fun plus(other: KotlinMoney): KotlinMoney{ // 객체 끼리의 연산자를 오버로딩해서 어떻게 처리할 지 작성할 수 있다.
        return KotlinMoney(this.value + other.value)
    }
}