/**
 * @author nakhoonchoi
 * @date 2024/06/05
 * @see https://www.acmicpc.net/problem/14728
 * @mem 17,152kb
 * @time 132ms
 * @caution
 * [고려사항]
 * 0-1 냅색 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP> '벼락치기'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt() // 물건의 개수
    val maxWeight = st.nextToken().toInt()

    val weightArr = IntArray(n)
    val valueArr = IntArray(n)

    for(i in 0 until n){
        st = StringTokenizer(readLine())
        weightArr[i] = st.nextToken().toInt() // 물건의 무게
        valueArr[i] = st.nextToken().toInt() // 물건의 가치
    }

    println(knapsack(maxWeight, weightArr, valueArr, n)) // 최대 가치 출력
}

fun knapsack(W: Int, weight: IntArray, value: IntArray, n: Int): Int {
    // dp[i][w] = 처음 i개의 아이템을 고려했을 때, 최대 무게가 w인 배낭의 최대 가치
    val dp = Array(n + 1) { IntArray(W + 1) }

    // 아이템 순회
    for (i in 1..n) {
        // 가능한 모든 무게에 대해 순회
        for (w in 1..W) {
            if (weight[i - 1] <= w) {
                // 아이템 i를 배낭에 추가할 수 있는 경우
                dp[i][w] = maxOf(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w])
            } else {
                // 아이템 i를 배낭에 추가할 수 없는 경우
                dp[i][w] = dp[i - 1][w]
            }
        }
    }

    // 최대 가치 반환
    return dp[n][W]
}