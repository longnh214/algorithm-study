/**
 * @author nakhoonchoi
 * @date 2024/05/04
 * @see https://www.acmicpc.net/problem/2745
 * @mem 12,524kb
 * @time 96ms
 * @caution
 * [고려사항]
 * String.toInt(numeralSystem) 형식의 출력을 통해 진법 변환을 하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '진법 변환'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val str = st.nextToken()
    val numeralSystem = st.nextToken().toInt()

    println(str.toInt(numeralSystem))
}