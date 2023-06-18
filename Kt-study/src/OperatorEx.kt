fun main() {
    val money = Money(2000L)
    val money2 = Money(1000L)

    if(money > money2){ //Java랑 다르게 객체를 비교할 때 비교 연산자를 사용하면 자동으로 compareTo를 호출해준다.
        println("Money가 Money2보다 가격이 높습니다.")
    }
}

class Money(var value : Long){
    operator fun compareTo(money2: Money) : Int { // Kotlin 에서 compareTo 구현법
        return when {
            this.value > money2.value -> 1
            this.value < money2.value -> -1
            else -> 0
        }
    }

    override fun equals(other: Any?): Boolean { //Kotlin 에서 equals 구현법.
        return if(other is Money)
            this.value === other.value
        else
            false
    }
}