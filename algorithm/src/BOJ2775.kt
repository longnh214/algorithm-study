/**
 * @author nakhoonchoi
 * @date 2024/05/31
 * @see https://www.acmicpc.net/problem/2775
 * @mem 12,036kb
 * @time 88ms
 * @caution
 * [고려사항]
 * k와 n에 제한이 있어서 dp 배열의 값을 먼저 초기화 하고, k와 n값을 입력 받아 배열의 값을 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP> '부녀회장이 될테야'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine().toInt()

    val dp = Array(15) { IntArray(15) { 0 } }

    for(i in 1..14){
        dp[0][i] = i
        dp[i][1] = 1
    }

    for(i in 1..14){
        for(j in 2..14){
            dp[i][j] = dp[i][j-1] + dp[i-1][j]
        }
    }

    for(i in 0 until T) {
        val k = readLine().toInt()
        val n = readLine().toInt()

        println(dp[k][n])
    }
}