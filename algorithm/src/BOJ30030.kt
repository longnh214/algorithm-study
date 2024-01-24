/**
 * @author nakhoon
 * @date 2024/01/24
 * @see https://www.acmicpc.net/problem/30030
 * @mem 12,152kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <사칙연산> '스위트콘 가격 구하기'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val A = readLine().toInt()

    println((A / 11) * 10)
}