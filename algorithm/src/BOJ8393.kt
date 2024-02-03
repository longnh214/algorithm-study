/**
 * @author naknak
 * @date 2/3/24
 * @see https://www.acmicpc.net/problem/8393
 * @mem 12,984kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 반복문 대신 dp 함수를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*
import java.io.*

//백준 <사칙연산, DP> '합'
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toInt()
    println(sum(num))
}

fun sum(num: Int): Int{
    return when(num){
        1 -> 1
        else -> sum(num - 1) + num
    }
}