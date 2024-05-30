/**
 * @author nakhoonchoi
 * @date 2024/05/30
 * @see https://www.acmicpc.net/problem/25206
 * @mem 14,060kb
 * @time 112ms
 * @caution
 * [고려사항]
 * 코틀린에서는 switch 문이 없기 때문에 when 절을 쓸 수 있었지만,
 * 대신에 map을 이용해서 미리 학점을 정의하고 불러오는 식으로 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '너의 평점은'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val scoreMap = hashMapOf(
        "A+" to 4.5,
        "A0" to 4.0,
        "B+" to 3.5,
        "B0" to 3.0,
        "C+" to 2.5,
        "C0" to 2.0,
        "D+" to 1.5,
        "D0" to 1.0,
        "F" to 0.0,
    )

    var sum = 0.0
    var totalPoint = 0.0
    for(i in 0 until 20){
        val st = StringTokenizer(readLine())
        st.nextToken()
        val point = st.nextToken().toDouble()
        val grade = st.nextToken()
        if(grade.equals("P")) {
            continue
        };
        sum += (point * scoreMap[grade]!!)
        totalPoint += point
    }
    println("%.6f".format(sum / totalPoint))
}