/**
 * @author nakhoonchoi
 * @date 2024/05/19
 * @see https://www.acmicpc.net/problem/16395
 * @mem 12,156kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 코틀린에서 2차원 배열을 만들려면, Array와 IntArray(or LongArray)를 적절히 활용해서 선언하면 되고,
 * 초기화 초기값도 선언이 가능하다.
 * 2차원 배열로 삼각형을 만들어서 점화식을 만들어 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '파스칼의 삼각형'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val dp = Array(n+1) { LongArray(n+1) {0} }
    dp[1][1] = 1
    for(i in 2..n){
        dp[i][1] = 1
        dp[i][i] = 1
        for(j in 2 until i){
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        }
    }

    println(dp[n][k])
}