/**
 * @author nakhoonchoi
 * @date 2024/01/30
 * @see https://www.acmicpc.net/problem/2884
 * @mem 12,216kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <사칙연산> '알람 시계'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    var hour = st.nextToken().toInt()
    var minute = st.nextToken().toInt()

    if(minute >= 45){
        minute -= 45;
    }else{
        minute += 60;
        minute -= 45;
        hour = (hour + 23) % 24
    }

    println(hour.toString() + " " + minute.toString())
}