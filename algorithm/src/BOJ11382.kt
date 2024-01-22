/**
 * @author nakhoonchoi
 * @date 2024/01/22
 * @see https://www.acmicpc.net/problem/11382
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <입출력> '꼬마 정민'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val A: Long = st.nextToken().toLong()
    val B: Long = st.nextToken().toLong()
    val C: Long = st.nextToken().toLong()

    println(A + B + C)
}