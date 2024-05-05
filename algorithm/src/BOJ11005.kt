/**
 * @author nakhoonchoi
 * @date 2024/05/05
 * @see https://www.acmicpc.net/problem/11005
 * @mem 12,760kb
 * @time 100ms
 * @caution
 * [고려사항]
 * Int 형의 ToString(numeralSystem) uppercase를 통해 진법 반대 변환을 하고, 대문자로 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '진법 변환 2'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val num = st.nextToken().toInt()
    val numeralSystem = st.nextToken().toInt()

    println(num.toString(numeralSystem).uppercase())
}