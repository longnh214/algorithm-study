/**
 * @author naknak
 * @date 4/25/24
 * @see https://www.acmicpc.net/problem/10431
 * @mem 17,872kb
 * @time 248ms
 * @caution
 * [고려사항]
 * 코틀린에서는 함수 매개변수나 괄호(값) 안에 조건문이 들어갈 수 있다...
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <구현> '줄세우기'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    for(i in 0 until n){
        val st = StringTokenizer(readLine())
        val testNum = st.nextToken().toInt()
        var count = 0
        val list = ArrayList<Int>()
        for(j in 0 until 20){
            val targetNum = st.nextToken().toInt()
            val index = list.indexOfFirst { it > targetNum }

            count += (if (index == -1) 0 else list.size - index)
            list.add(if (index == -1) list.size else index, targetNum)
        }

        println("${testNum} ${count}")
    }
}