/**
 * @author nakhoonchoi
 * @date 2024/05/03
 * @see https://www.acmicpc.net/problem/2748
 * @mem 12,168kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '피보나치 수 2'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = LongArray(91)

    arr[0] = 0
    arr[1] = 1
    for(i in 2..n) {
        arr[i] = arr[i-1] + arr[i-2]
    }
    println(arr[n])
}