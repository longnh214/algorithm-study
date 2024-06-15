/**
 * @author nakhoonchoi
 * @date 2024/06/15
 * @see https://www.acmicpc.net/problem/10872
 * @mem 12,144kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 재귀를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '팩토리얼'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    println(factorial10872(n))
}

fun factorial10872(n: Int): Int {
    if (n == 0) return 1
    return n * factorial10872(n - 1)
}