/**
 * @author naknak
 * @date 2/1/24
 * @see https://www.acmicpc.net/problem/10950
 * @mem 12,312kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 코틀린의 for문 문법 중 in에 대해 연습할 수 있었던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <반복문> 'A+B - 3'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    for(i in 1..N){
        val st = StringTokenizer(readLine())
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()
        println(A+B)
    }
}