/**
 * @author naknak
 * @date 1/31/24
 * @see https://www.acmicpc.net/problem/2525
 * @mem 12,192kb
 * @time 88ms
 * @caution
 * [고려사항]
 * plusMinutes가 60보다 클 수 있으므로 60으로 나눈 나머지를 기준으로 분기처리해서 계산해야했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <조건문> '오븐 시계'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    var hour = st.nextToken().toInt()
    var minute = st.nextToken().toInt()
    val plusMinute = readLine().toInt()

    if(minute < 60 - (plusMinute % 60)){
        minute += (plusMinute % 60);
        hour = (hour + (plusMinute / 60)) % 24;
    }else{
        minute += (plusMinute % 60);
        minute -= 60;
        hour = (hour + (plusMinute / 60) + 1) % 24
    }

    println("$hour $minute")
}