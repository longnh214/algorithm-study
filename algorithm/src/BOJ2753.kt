/**
 * @author nakhoonchoi
 * @date 2024/01/27
 * @see https://www.acmicpc.net/problem/
 * @mem 12,156kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <조건문> '윤년'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val year = readLine().toInt()

    if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
        println("1")
    }else{
        println("0")
    }
}