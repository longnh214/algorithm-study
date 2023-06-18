fun main() {
    val money = Money(1000L)
    val money2 = money
    val money3 = Money(1000L)

    // Java에서는 동일성에 ==, 동등성에 equals를 직접 호출
    // Kotlin에서는 동일성에 ===, 동등성에 ==를 호출
    // ==를 사용하면 간접적으로 equals를 호출한다.

    println(money === money2)
    println(money == money2)
    println(money === money3)
    println(money == money3)

}