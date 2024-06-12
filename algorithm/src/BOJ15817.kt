/**
 * @author nakhoonchoi
 * @date 2024/06/12
 * @see https://www.acmicpc.net/problem/15817
 * @mem 21,424kb
 * @time 288ms
 * @caution
 * [고려사항]
 * 냅색 문제였지만, 각 파이프마다 개수가 1개가 아닌 여러 개가 올 수 있어서 조금 생각해야했던 문제이다.
 * 기존 냅색처럼 풀었지만, 2차원 배열이 아닌 1차원 배열로도 문제를 해결할 수 있는듯하다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP, 냅색> '배수 공사'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val dp = Array(n + 1){ IntArray(x + 1){ 0 } }

    for(i in 0 .. n){
        dp[i][0] = 1
    }

    for(i in 1..n){
        st = StringTokenizer(readLine())
        val l = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        for(j in 1..x){
            for(k in 0..c){
                if(j - k * l < 0){
                    break
                }
                dp[i][j] += dp[i - 1][j - k * l]
            }
        }
    }

    println(dp[n][x])
}