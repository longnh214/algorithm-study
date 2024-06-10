/**
 * @author nakhoonchoi
 * @date 2024/06/10
 * @see https://www.acmicpc.net/problem/29704
 * @mem 17,124kb
 * @time 144ms
 * @caution
 * [고려사항]
 * 백준 14728번의 벼락치기와는 다른 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP, 냅색> '벼락치기'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val t = st.nextToken().toInt()

    var sum = 0

    val weightArr = IntArray(n)
    val valueArr = IntArray(n)

    for(i in 0 until n){
        st = StringTokenizer(readLine())
        weightArr[i] = st.nextToken().toInt()
        valueArr[i] = st.nextToken().toInt()

        sum += valueArr[i]
    }

    val dp = Array(n + 1) { IntArray(t + 1) }

    for(i in 1..n){
        for(j in 1..t){
            if(weightArr[i-1] <= j){
                dp[i][j] = maxOf(dp[i-1][j], valueArr[i-1] + dp[i-1][j-weightArr[i-1]])
            }else{
                dp[i][j] = dp[i-1][j]
            }
        }
    }

    println(sum - dp[n][t])
}