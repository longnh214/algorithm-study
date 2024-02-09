/**
 * @author naknak
 * @date 2/9/24
 * @see https://www.acmicpc.net/problem/11022
 * @mem 12,396kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <반복문> 'A+B-8'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for(i in 1..N){
        val st = StringTokenizer(readLine())
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()

        bw.write("Case #${i}: ${A} + ${B} = ${(A+B).toString()}")
        bw.write("\n")
    }

    bw.flush()
}