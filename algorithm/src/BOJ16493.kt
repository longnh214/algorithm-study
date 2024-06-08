/**
 * @author nakhoonchoi
 * @date 2024/06/08
 * @see https://www.acmicpc.net/problem/16493
 * @mem 12,336kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 냅색 문제 연습했습니다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP, 냅색> '최대 페이지 수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val weightArr = IntArray(m)
    val valueArr = IntArray(m)

    for(i in 0 until m){
        st = StringTokenizer(readLine())
        weightArr[i] = st.nextToken().toInt() // 물건의 무게
        valueArr[i] = st.nextToken().toInt() // 물건의 가치
    }

    val dp = Array(m + 1){ IntArray(n + 1) }

    for(i in 1..m){
        for(j in 1..n){
            if(weightArr[i-1] <= j){
                dp[i][j] = maxOf(valueArr[i-1] + dp[i-1][j-weightArr[i-1]], dp[i-1][j])
            }else{
                dp[i][j] = dp[i-1][j]
            }
        }
    }

    println(dp[m][n])
}