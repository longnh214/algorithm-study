/**
 * @author nakhoonchoi
 * @date 2024/04/28
 * @see https://www.acmicpc.net/problem/2747
 * @mem 12,148kb
 * @time 88ms
 * @caution
 * [고려사항]
 * Array를 생성하고 dp를 이용해서 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '피보나치 수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = IntArray(46)
    arr[1] = 1

    for(i in 2 until arr.size){
        arr[i] = arr[i-1] + arr[i-2]
    }

    println(arr[N])
}