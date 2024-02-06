/**
 * @author naknak
 * @date 2/7/24
 * @see https://www.acmicpc.net/problem/15552
 * @mem 245,400kb
 * @time 820ms
 * @caution
 * [고려사항]
 * 출력시 System.out.println 이 아닌 BufferedWriter를 통해
 * 메모리와 효율성을 높여야 했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <반복문> '빠른 A+B'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for(i in 1..N){
        val st = StringTokenizer(readLine())
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()

        bw.write((A+B).toString())
        bw.write("\n")
    }

    bw.flush()
}