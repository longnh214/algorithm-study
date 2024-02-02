/**
 * @author naknak
 * @date 2/2/24
 * @see https://www.acmicpc.net/problem/2480
 * @mem 12,348kb
 * @time 88ms
 * @caution
 * [고려사항]
 * when 절과 Map을 이용해서 문제를 해결할 수 있었다.
 * javascript처럼 Map에 배열처럼 인덱스로 접근이 가능한 점에서 신기했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <조건문> '주사위 세 개'
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val map = HashMap<Int, Int>()

    for (i in 1..3) {
        val value = st.nextToken().toInt()

        map[value] = map.getOrDefault(value, 0) + 1
    }

    var max: Int = 0
    var targetValue: Int = 0

    for(i in map.keys){
        if(map[i]!! > max){
            max = map[i]!!
            targetValue = i
        }else if(map[i]!! == max && i > targetValue){
            targetValue = i
        }
    }

    when (max) {
        3 -> println(10000 + targetValue * 1000)
        2 -> println(1000 + targetValue * 100)
        else -> println(targetValue * 100)
    }
}