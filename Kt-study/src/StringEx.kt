fun main(){
    val person = Person("나는 사람이다.")
    val log = "Person's name is ${person.name}." //${}에 변수를 넣는다.
    println(log)

    val multiLineStr = """
        
        오 문자열 겁나 신기해...
        
        
        
    """.trimIndent()

    println(multiLineStr)

    println(person.name[1]) // 특정 문자 가져오기.
}