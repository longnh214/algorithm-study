/**
 * @author nakhoonchoi
 * @date 2024/05/18
 * @see https://www.acmicpc.net/problem/13301
 * @mem 12,208kb
 * @time 88ms
 * @caution
 * [고려사항]
 * dp 초기값을 설정하고, 3부터는
 * dp[i] = dp[i-1] + dp[i-2] 점화식을 이용해서 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP> '타일 장식물'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val dp = LongArray(if(N == 1) 3 else N+1)

    dp[1] = 4
    dp[2] = 6
    for(i in 3 until N+1){
        dp[i] = dp[i-1] + dp[i-2]
    }

    println(dp[N])
}