/**
 * @author nakhoonchoi
 * @date 2024/06/07
 * @see https://www.acmicpc.net/problem/1535
 * @mem 12,324kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 냅색 문제이지만,
 * 문제를 보고 maxWeight가 100이 아니라 99임을 확인해야 하는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP, 냅색> '안녕'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val maxWeight = 99

    val weightArr = IntArray(n)
    val valueArr = IntArray(n)

    var st = StringTokenizer(readLine())
    for (i in 0 until n) {
        weightArr[i] = st.nextToken().toInt()
    }

    st = StringTokenizer(readLine())
    for (i in 0 until n) {
        valueArr[i] = st.nextToken().toInt()
    }

    val dp = Array(n + 1){ IntArray(maxWeight + 1) }

    for(i in 1..n){
        for(w in 1..maxWeight){
            if(weightArr[i-1] <= w){
                dp[i][w] = maxOf(valueArr[i-1] + dp[i-1][w-weightArr[i-1]], dp[i-1][w])
            }else{
                dp[i][w] = dp[i-1][w]
            }
        }
    }

    println(dp[n][maxWeight])
}