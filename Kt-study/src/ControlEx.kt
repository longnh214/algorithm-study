fun validateScoreIsNotNegative(score: Int){ // Java와 같다.
    if(score < 0){
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.") // new 사용 안한다.
    }
}

fun validateScore(score: Int){ // Java와 같다.
    if(score in 0..100){
        throw IllegalArgumentException("${score}는 0에서 100 사이입니다.") // new 사용 안한다.
    }
}

fun getPassOrFail(score: Int): String{ // Java에서 if-else는 statement(문장)이지만, Kotlin에서는 Expression(하나의 문장)이다.
    return if(score >= 50)
        "P"
    else
        "F"
    //와 같이 return 아래에 넣을 수 있다. 대신에 삼항 연산자는 없다.
}

fun getGrade(score: Int): String{ // if-else if-else도 마찬가지이다.
    return if(score >= 90)
        "A"
    else if(score >= 80)
        "B"
    else if(score >= 70)
        "C"
    else
        "D"
}

fun getShortGrade(score: Int) :String{
    //if(0 <= score && score <= 100)
    return if(score in 0..100) // 0 <= score <= 100 을 0..100으로 표현
        "A"
    else
        "D"
}

fun getGradeWithSwtich(score: Int): String{
    //switch, case 문이 사라졌습니다.
    //대신에 when을 쓰고, 화살표를 이용해서 case를 표현했다.
    return when (score / 10){
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithSwtich2(score: Int): String{
    return when (score){
        in 90..99 -> "A" //범위 조건도 case에 넣을 수 있다.
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any?) {
    when(obj){
        is String -> obj.startsWith("A") // A로 시작하면 true, 아니면 false
        else -> false
    }
}

fun judgeNumber(number: Int){
    when(number){
        1, 0, -1 -> println("어디서 많이 본 숫자 입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int){ // when에 값을 넣지 않음으로서 early return 기능이 가능하다.
    when{
        number == 0 -> println("주어진 숫자는 0 입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}

fun main() {
    judgeNumber2(200)
}

/**
 * private void judgeNumber2(int number){
 *  if(number == 0){
 *      System.out.println("주어진 숫자는 0입니다.");
 *      return;
 *  }else if(number % 2 == 0){
 *      System.out.println("주어진 숫자는 짝수입니다.");
 *      return;
 *  }
 *
 *  System.out.println("주어진 숫자는 홀수입니다.");
 * }
 *
 */