fun main(){
    var number1 : Long = 10L //reference type, primitive 타입을 똑똑하게 알아서 boxing / unboxing을 고려하지 않도록 처리해준다.

    var number2 : Long? = null // null을 추가하려면 타입에 ?를 붙여야한다.

    var person = Person("낙낙이")

    println(person.name)

}

class Person(val name: String){
}