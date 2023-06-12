fun main() {
    val person = null
    printNameIfPerson(person)
    printNameIfPerson2(person)
}

fun printNameIfPerson(obj: Any?){
    if(obj is Person){ // is = instanceof
        //println(obj.name) 도 가능하다.

        val person = obj as Person

        println(person.name)
    }

    if(obj !is Person){ //not is를 표현한다.
        println("사람이 아니다")
    }
}

fun printNameIfPerson2(obj: Any?){
    val person2 = obj as? Person // obj가 null일 경우에 person2는 null이 된다.(타입 캐스팅)
    println(person2?.name) // person2는 null이 될 수 있기에 Safe call을 해줘야한다.
}