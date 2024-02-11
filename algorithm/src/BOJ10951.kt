/**
 * @author naknak
 * @date 2/11/24
 * @see https://www.acmicpc.net/problem/10951
 * @mem 12,356kb
 * @time 92ms
 * @caution
 * [고려사항]
 * Kotlin 내장 함수인 also 함수를 통해 조건문 안에 인스턴스에 값을 할당할 수 있는
 * 방법을 배울 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <반복문> 'A+B-4'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var str: String?

    while (readLine().also { str = it } != null) {
        val st = StringTokenizer(str)
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()

        bw.write((A+B).toString())
        bw.write("\n")
    }

    bw.flush()
}