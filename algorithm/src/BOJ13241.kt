/**
 * @author nakhoonchoi
 * @date 2024/05/29
 * @see https://www.acmicpc.net/problem/13241
 * @mem 12,232kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 최대공약수를 이용해 최소공배수를 구하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '최소공배수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()

    val gcd = gcd(a, b)
    println(a * b / gcd)
}

fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}