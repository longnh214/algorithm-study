/**
 * @author nakhoonchoi
 * @date 2024/05/27
 * @see https://www.acmicpc.net/problem/4153
 * @mem 12,180kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <기하학> '직각삼각형'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    while(true){
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        if(a == 0 && b == 0 && c == 0) break

        if(a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a){
            println("right")
        }else{
            println("wrong")
        }
    }
}