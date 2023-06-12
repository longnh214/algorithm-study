fun main(){
    val person = Person("공부하는 개발자")
    println(startsWithA(person.name))
}

fun startsWithA(str: String?): Boolean{
    return str?.startsWith("A") ?: false
}
