/**
 * @author nakhoonchoi
 * @date 2024/05/26
 * @see https://www.acmicpc.net/problem/1085
 * @mem 12,536kb
 * @time 88ms
 * @caution
 * [고려사항]
 * Java로 문제를 많이 풀어서 Math.min에 익숙해져있는데,
 * 숫자에도 CompareTo 처럼 coerceAtMost 함수가 있다는 것을 알 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <기하학> '직사각형에서 탈출'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    println(x.coerceAtMost(w - x).coerceAtMost(y.coerceAtMost(h - y)))
}