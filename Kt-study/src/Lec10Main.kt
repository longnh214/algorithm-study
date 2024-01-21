fun main() {
    Derived(300) //이 상태로 Derived 클래스를 생성하면 300도, 100도 아닌 0이 출력된다.
}

open class Base(
        open val number: Int = 100
){
    init {
        println("Base Class")
        println("number : ${number}") // 해당 부분에서 하위 클래스에 300을 넣어서 호출했지만. Base의 number는 아직 constructor가 호출되지 않아 초기화 되지 않았다. 그래서 0 출력.
        //상위 클래스의 constructor와 init 블록에서는 하위 클래스의 field에 접근해서는 안된다.(Accessing non-final property number in constructor)
        //즉 하위 클래스에서 override하고 있는 프로퍼티에 접근해서는 안된다.

        //상위 클래스를 설계할 때, 생성자 또는 init 블록에 사용되는 프로퍼티에는 open을 피해야한다.
    }
}

class Derived(
        override val number: Int
) : Base(number) {
    init {
        println("Derived Class")
        println("number : ${number}")
    }
}

//1. final : override를 할 수 없게 한다. default로 보이지 않게 존재한다.
//2. open : override를 열어준다.
//3. abstract : 반드시 override 해야하는 프로퍼티이다.
//4. override : 상위 타입을 오버라이드 하고 있다.