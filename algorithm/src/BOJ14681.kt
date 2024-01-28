/**
 * @author nakhoonchoi
 * @date 2024/01/28
 * @see https://www.acmicpc.net/problem/14681
 * @mem 12,168kb
 * @time 92ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <조건문> '사분면 고르기'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val A = readLine().toInt() > 0
    val B = readLine().toInt() > 0

    when{
        A && B -> println("1")
        !A && B -> println("2")
        !A && !B -> println("3")
        else -> println("4")
    }
}