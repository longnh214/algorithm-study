/**
 * @author nakhoonchoi
 * @date 2024/05/21
 * @see https://www.acmicpc.net/problem/15992
 * @mem 23,784kb
 * @time 252ms
 * @caution
 * [고려사항]
 * 2차원 배열을 이용해 사용한 숫자의 개수와 대상 숫자를 배열의 원소로 지정하고, 점화식을 이용해서 답을 구할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '1,2,3 더하기 7'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine().toInt()
    val MOD = 1000000009
    val dp = Array(1001){ LongArray(1001) {0} }

    dp[1][1] = 1
    dp[2][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 2
    dp[3][3] = 1

    for(i in 4..1000){
        for(j in 1..i){
            dp[i][j] = dp[i-1][j-1]
            dp[i][j] = (dp[i][j] + dp[i-2][j-1]) % MOD
            dp[i][j] = (dp[i][j] + dp[i-3][j-1]) % MOD
        }
    }

    for(i in 0 until T){
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        println((dp[n][m]) % MOD)
    }
}