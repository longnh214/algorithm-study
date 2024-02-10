/**
 * @author naknak
 * @date 2/10/24
 * @see https://www.acmicpc.net/problem/10952
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <반복문> 'A+B-5'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while(true){
        val st = StringTokenizer(readLine())
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()

        if(A == 0 && B == 0) {
            break
        }

        bw.write((A+B).toString())
        bw.write("\n")
    }

    bw.flush()
}