/**
 * @author naknak
 * @date 2/15/24
 * @see https://www.acmicpc.net/problem/10818
 * @mem 116,656kb
 * @time 436ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <배열> '최소, 최대'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val st = StringTokenizer(readLine())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var max = Integer.MIN_VALUE
    var min = Integer.MAX_VALUE

    for(i in 1 .. N){
        val num = st.nextToken().toInt()

        min = Math.min(min, num)
        max = Math.max(max, num)
    }

    bw.write(min.toString())
    bw.write(" ")
    bw.write(max.toString())

    bw.flush()
    bw.close()
}