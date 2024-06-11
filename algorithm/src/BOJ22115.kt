/**
 * @author nakhoonchoi
 * @date 2024/06/11
 * @see https://www.acmicpc.net/problem/22115
 * @mem 56,236kb
 * @time 344ms
 * @caution
 * [고려사항]
 * 일반적인 냅색 문제와는 성격이 달라서, (MIN을 구해야함)
 * 어려웠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP, 냅색> '창영이와 커피'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val weightArr = IntArray(n)
    st = StringTokenizer(readLine())

    for(i in 0 until n){
        weightArr[i] = st.nextToken().toInt()
    }

    val dp = Array(n + 1){ IntArray(k + 1){1000000} }

    for(i in 0 .. n){
        dp[i][0] = 0
    }

    for(i in 1..n){
        for(j in 1..k){
            if(j < weightArr[i - 1]){
                dp[i][j] = dp[i - 1][j]
            }else {
                dp[i][j] = minOf(dp[i - 1][j], dp[i - 1][j - weightArr[i - 1]] + 1)
            }
        }
    }

    println(if (dp[n][k] == 1000000) "-1" else dp[n][k])
}