/**
 * @author nakhoonchoi
 * @date 2024/05/24
 * @see https://www.acmicpc.net/problem/1402
 * @mem 12,132kb
 * @time 92ms
 * @caution
 * [고려사항]
 * A = A * (-1) * (-1) * 1 * 1 과 같이 약수 중 음수도 가능하므로
 * A' = A + (-1) + (-1) + 1 처럼 모든 수에 대해 A와 A'로 변할 수 있다는 것을 알 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <애드훅> '아무래도이문제는A번난이도인것같다'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var T = readLine().toInt()
    val sb = StringBuilder()
    while(T-->0){
        sb.append("yes\n")
    }
    println(sb)
}