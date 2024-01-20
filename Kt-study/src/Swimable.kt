interface Swimable {
    val swimAbility: Int //인터페이스에서 필드를 넣어줄 수도 있다.

    fun act(){ //default 키워드가 없어도 default 함수 작성 가능
        println("어푸 어푸")
    }
}