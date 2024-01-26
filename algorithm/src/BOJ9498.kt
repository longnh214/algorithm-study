/**
 * @author nakhoonchoi
 * @date 2024/01/26
 * @see https://www.acmicpc.net/problem/9498
 * @mem 12,156kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 조건문 when과 range 체크를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <조건문> '시험 성적'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    when (readLine().toInt()) {
        in 90..100 -> println("A")
        in 80..89 -> println("B")
        in 70..79 -> println("C")
        in 60..69 -> println("D")
        else -> println("F")
    }
}