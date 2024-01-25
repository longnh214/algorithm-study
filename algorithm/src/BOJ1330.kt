/**
 * @author naknak
 * @date 1/25/24
 * @see https://www.acmicpc.net/problem/1330
 * @mem 12,188kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 코틀린에서 조건문 새 문법 when을 연습할 수 있었던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <조건문> '두 수 비교하기'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    when {
        a == b -> println("==")
        a < b -> println("<")
        else -> println(">")
    }
}