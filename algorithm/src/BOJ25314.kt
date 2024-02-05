/**
 * @author naknak
 * @date 2/5/24
 * @see https://www.acmicpc.net/problem/25314
 * @mem 12,184kb
 * @time 84ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <반복문> '코딩은 체육과목 입니다'
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    val sb = StringBuilder()

    for(i in 1..N/4){
        sb.append("long ")
    }
    sb.append("int")

    println(sb)
}