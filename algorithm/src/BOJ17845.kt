/**
 * @author nakhoonchoi
 * @date 2024/06/06
 * @see https://www.acmicpc.net/problem/17845
 * @mem 50,716kb
 * @time 196ms
 * @caution
 * [고려사항]
 * 0-1 냅색 문제 연습용 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP> '수강 과목'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val maxWeight = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val weightArr = IntArray(n)
    val valueArr = IntArray(n)

    for(i in 0 until n){
        st = StringTokenizer(readLine())
        valueArr[i] = st.nextToken().toInt()
        weightArr[i] = st.nextToken().toInt()
    }

    println(knapsack2(maxWeight, weightArr, valueArr, n))
}

fun knapsack2(W: Int, weight: IntArray, value: IntArray, n: Int): Int {
    // dp[i][w] = 처음 i개의 아이템을 고려했을 때, 최대 무게가 w인 배낭의 최대 가치
    val dp = Array(n + 1) { IntArray(W + 1) }

    // 아이템 순회
    for(i in 1..n){
        for(w in 1..W){
            if(weight[i-1] <= w){
                dp[i][w] = maxOf(value[i-1] + dp[i-1][w-weight[i-1]], dp[i-1][w])
            }else{
                dp[i][w] = dp[i-1][w]
            }
        }
    }
    return dp[n][W]
}