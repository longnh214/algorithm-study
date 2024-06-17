/**
 * @author nakhoonchoi
 * @date 2024/06/17
 * @see https://www.acmicpc.net/problem/14490
 * @mem 12,112kb
 * @time 84ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '백대열'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), ":")
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    val gcd = gcd14490(a, b)

    println("${a / gcd}:${b / gcd}")
}

fun gcd14490(a: Int, b: Int): Int {
    return if (b == 0) a else gcd14490(b, a % b)
}