class Penguin(
        species: String
) : Animal(species, 2), Flyable, Swimable { //implement 키워드 없이 Animal 추상 클래스 뒤에 ,로 붙여준다.
    private val wingCount: Int = 2
    override fun move() {
        println("펭귄이 움직인다!!! 이쿠!")
//        TODO("Not yet implemented")
    }

    //추상 프로퍼티가 아니라면, 상속 받을 때 해당 프로퍼티에 open을 꼭 붙여야한다.
    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Flyable>.act() //super<Type>.메소드로 표현한다.
        super<Swimable>.act()
    }

    override fun fly() {
        println("날아올라~")
        TODO("Not yet implemented")
    }

    override val swimAbility: Int //Swimable의 swimAbility 필드 값을 3으로 고정.
        get() = 3
}