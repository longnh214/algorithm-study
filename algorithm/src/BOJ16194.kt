/**
 * @author nakhoonchoi
 * @date 2024/05/17
 * @see https://www.acmicpc.net/problem/16194
 * @mem 12,824kb
 * @time 112ms
 * @caution
 * [고려사항]
 * dp 배열을 초기화할 때 자동으로 0으로 초기화되기 때문에 초기값을 잘 세팅해야했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '카드 구매하기 2'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = IntArray(N)
    val dp = IntArray(N+1)
    val st = StringTokenizer(readLine())
    for(i in 0 until N){
        arr[i] = st.nextToken().toInt()
        dp[i+1] = arr[i]
    }

    for(i in 1 until N+1){
        for(j in 0 until i){
            dp[i] = Math.min(dp[i], dp[j] + dp[i - j])
        }
    }

    println(dp[N])
}