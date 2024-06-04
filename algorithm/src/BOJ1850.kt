/**
 * @author nakhoonchoi
 * @date 2024/06/04
 * @see https://www.acmicpc.net/problem/1850
 * @mem 60,240kb
 * @time 248ms
 * @caution
 * [고려사항]
 * repeat를 통해 특정 숫자만큼 반복하는 코틀린 문법을 학습할 수 있었다.
 * 그리고 repeat 구문 안에서 1을 직접 print 하는 방식으로
 * 문제를 해결했을 때에는 시간 초과가 발생했고,
 * StringBuilder를 통해 문자열을 추가해서 한 번에 출력하는 식으로
 * AC를 받을 수 있었다.
 *
 * 입출력 로직이 확실히 시간이 오래 걸리는 것 같다...
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '최대공약수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()

    val sb = StringBuilder()
    repeat(gcd2(a, b).toInt()) {
        sb.append('1')
    }
    println(sb.toString())
}

fun gcd2(a: Long, b: Long): Long{
    return if(b == 0L) a else gcd2(b, a % b)
}