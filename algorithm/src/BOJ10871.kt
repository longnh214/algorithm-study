/**
 * @author naknak
 * @date 2/14/24
 * @see https://www.acmicpc.net/problem/10871
 * @mem 14,176kb
 * @time 124ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <배열> 'X보다 작은 수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val X = st.nextToken().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    st = StringTokenizer(readLine())

    for(i in 1 .. N){
        val num = st.nextToken().toInt()
        if(num < X){
            bw.write(num.toString())
            bw.write(" ")
        }
    }
    bw.flush()
    bw.close()
}