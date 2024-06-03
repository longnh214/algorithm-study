/**
 * @author nakhoonchoi
 * @date 2024/06/03
 * @see https://www.acmicpc.net/problem/2670
 * @mem 15,920kb
 * @time 144ms
 * @caution
 * [고려사항]
 * dp를 이용해서 문제를 해결할 수 있었다.
 * double 형으로 입력 받아서 곱해야했고, format을 이용해서 소수점 셋째 자리까지 출력해야했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '연속부분최대곱'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = DoubleArray(n+1)
    val arr = DoubleArray(n+1)
    var max = 0.0
    for(i in 1..n){
        arr[i] = readLine().toDouble()
        dp[i] = arr[i].coerceAtLeast(dp[i - 1] * arr[i]);
        max = max.coerceAtLeast(dp[i])
    }
    println("%.3f".format(max))
}