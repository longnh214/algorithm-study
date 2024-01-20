interface Flyable {
    fun act(){ //default 키워드가 없어도 default 함수 작성 가능
        println("파닥 파닥")
    }

    fun fly() //추상 메소드
}