class Cat(
        species: String //Cat의 생성자
) : Animal(species, 4) { // 상속 받을 때에는 :이 스페이스가 있어야하고, 변수 옆 콜론(:)은 스페이스가 없어야 한다. ex) val num: Int // class Cat : Animal
    // 코틀린에서는 생성자를 호출할 때 상위 클래스의 생성자를 바로 호출한다.
    override fun move() { //override를 필수적으로 기입한다.
        println("고양이가 사뿐 사뿐 걸어가~")
//        TODO("Not yet implemented")
    }

}