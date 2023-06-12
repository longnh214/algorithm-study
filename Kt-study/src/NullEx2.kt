fun main(){
    println(startsWithA4(null))
}

fun startsWithA1(str: String?): Boolean { // null이 들어올 수 없는 Boolean
//    if(str == null){
//        throw IllegalArgumentException("Null Exception")
//    }
//    return str.startsWith("A")
    return str?.startsWith("A") ?: throw IllegalArgumentException("Null Exception")
}

fun startsWithA2(str: String?): Boolean? { // null이 들어올 수 있는 Boolean
//    if(str == null){
//        return null
//    }
//    return str.startsWith("A")
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean{
//    if(str == null){
//        return false
//    }
//    return str.startsWith("A") // 위에서 null 체크를 하면, null이 아니겠거니, 컴파일러가 자동으로 추측한다.
    return str?.startsWith("A") ?: false
}

fun startsWithA4(str: String?) : Boolean{
    return str!!.startsWith("A") // !!. 는 절대 str이 null일 리 없어! 라는 의미의 연산자이다.
}