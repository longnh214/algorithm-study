/**
 * @author naknak
 * @date 2/13/24
 * @see https://www.acmicpc.net/problem/10807
 * @mem 12,312kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 배열 대신 map으로 해결하는 것이 더 효율적일 거 같아 map으로 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <배열> '개수 세기'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val map = HashMap<Int, Int>()
    val st = StringTokenizer(readLine())

    for(i in 1 .. N){
        val num = st.nextToken().toInt();
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    val target = readLine().toInt()
    println(map.getOrDefault(target, 0))
}