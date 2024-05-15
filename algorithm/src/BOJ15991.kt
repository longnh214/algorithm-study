/**
 * @author nakhoonchoi
 * @date 2024/05/15
 * @see https://www.acmicpc.net/problem/15991
 * @mem 14,600kb
 * @time 204ms
 * @caution
 * [고려사항]
 * 처음에는 어렵게 생각했지만, 앞 dp 배열에 6 전까지 대칭의 정답이 저장되어있다는 가정 하에,
 * 양 옆에 1,1 / 2,2 / 3,3을 넣으면 대칭이 되지 않을까? 생각했다.
 * 예를 들어 6의 경우
 * dp[0]에서 양 옆에 3 + 0 + 3
 * dp[2]에서 양 옆에 2 + (2의 수들) + 2
 * dp[4]에서 양 옆에 1 + (4의 수들) + 1
 * 이라고 생각하니 경우의 수를 계산하기 쉬워졌다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '1,2,3 더하기 6'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dp = LongArray(100001)
    val T = readLine().toInt()
    val MOD = 1000000009

    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    dp[3] = 2
    dp[4] = 3
    dp[5] = 3

    for(i in 6..100000){
        dp[i] = dp[i-2]
        dp[i] = (dp[i] + dp[i-4]) % MOD
        dp[i] = (dp[i] + dp[i-6]) % MOD
    }

    for(i in 0 until T){
        val N = readLine().toInt()
        println((dp[N]) % MOD)
    }
}