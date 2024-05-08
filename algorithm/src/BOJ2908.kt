/**
 * @author nakhoonchoi
 * @date 2024/05/08
 * @see https://www.acmicpc.net/problem/2908
 * @mem 14,464kb
 * @time 116ms
 * @caution
 * [고려사항]
 * 문자열을 입력받아 reversed()한 후, int로 변환하여 비교했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '상수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val num1 = st.nextToken().reversed().toInt()
    val num2 = st.nextToken().reversed().toInt()

    println(if(num1 > num2) num1 else num2)
}