/**
 * @author nakhoonchoi
 * @date 2024/06/18
 * @see https://www.acmicpc.net/problem/9996
 * @mem 15,448kb
 * @time 136ms
 * @caution
 * [고려사항]
 * 정규 표현식을 연습할 수 있는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <문자열> '한국이 그리울 땐 서버에 접속하지'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val regex = readLine().replace("*",".*").toRegex()

    for(i in 0 until n){
        val s = readLine()
        if(regex.matches(s)){
            println("DA")
        }else{
            println("NE")
        }
    }
}