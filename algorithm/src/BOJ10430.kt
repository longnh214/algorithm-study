/**
 * @author nakhoon
 * @date 2024/01/17
 * @see https://www.acmicpc.net/problem/10430
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '나머지'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val A = Integer.parseInt(st.nextToken())
    val B = Integer.parseInt(st.nextToken())
    val C = Integer.parseInt(st.nextToken())

    println((A+B)%C)
    println(((A%C) + (B%C))%C)
    println((A*B)%C)
    println(((A%C) * (B%C))%C)
}