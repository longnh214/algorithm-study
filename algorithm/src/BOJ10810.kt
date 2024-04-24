/**
 * @author naknak
 * @date 4/24/24
 * @see https://www.acmicpc.net/problem/10810
 * @mem 18,656kb
 * @time 128ms
 * @caution
 * [고려사항]
 * Arrays.fill의 인덱스를 조심해야했고,
 * 코틀린에서는 Array에 joinToString 함수가 존재한다.
 * [입력사항]
 * [출력사항]
 */

//백준 <배열> '공 넣기'
import java.util.*;
import java.io.*;

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val arr = IntArray(n)

    for(i in 0 until m){
        st = StringTokenizer(readLine())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        Arrays.fill(arr, i-1, j, k)
    }

    println(arr.joinToString(separator = " "))
}