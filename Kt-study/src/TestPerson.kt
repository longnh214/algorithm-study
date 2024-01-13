//class TestPerson constructor(name: String, age: Int){
//class TestPerson(name: String, age: Int){ //생성자 constructor 키워드 생략 가능
//    //getter와 setter는 자동으로 만들어준다.
//    val name = name
//    var age = age
//}

//최대로 축약하면 body, {}를 없애고 생성자만으로 getter,setter를 생략해서 선언할 수 있다.
class TestPerson(
        name: String, //기본 생성자 (주 생성자는 반드시 존재해야 한다.)
        var age: Int
){

    var name = name //setter를 쓰기 위해 val에서 var로 변경. setter를 지양하기 때문에 custom setter도 잘 안 쓴다.
        get() = field.uppercase() //custom getter와 다르게 field를 선언해야한다. field는 자기 자신을 가르키는 예약어이다.(backing field)
        set(value) {
            field = value.uppercase() //backing field를 통해 무한루프를 막는다.
        }
    //name.uppercase()를 하게되면 name에서 name의 get()을 호출하기 때문에 순환 호출이 일어날 수 있다.

//    val uppercaseName: String
//        get() = name.uppercase()

    val uppercaseName: String = name.uppercase() //따로 uppercase 필드를 만들어준다.

    init { //초기화 블록은 생성자가 호출 시점에 호출된다.(검증 로직 작성 가능)
        if(age <= 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("초기화 블록")
    }

    constructor(name: String): this(name, 1){ //부생성자 : 있을 수도 있고, 없을 수도 있다. (부생성자는 내부 로직에서 주생성자를 호출해야한다.)
       println("첫 번째 부생성자")
    }

    constructor(): this("홍길동"){
        println("두 번째 부생성자")
    }

//    fun isAdult() : Boolean{
//        return this.age >= 20
//    }

    val isAdult: Boolean //custom getter
        get() = this.age >= 20
//        get(){ get()을 두 가지로 표현 가능.
//            return this.age >= 20
//        }


}

fun main(){
    val person = TestPerson("naknak", 100) //Java 클래스의 getter, setter를 이용해서 가져올 수 있다.(호환)
    val person2 = TestPerson("naknak")
    println(person.name)
    person.age = 10
    println(person.age)
    println(person2.age)
    val person3 = TestPerson() // 초기화 블록부터 첫 번째, 두 번째 순으로 역순으로 실행된다.(부생성자보다는 default parameter를 권장한다.)
}