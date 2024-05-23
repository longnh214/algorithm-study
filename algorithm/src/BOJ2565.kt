/**
 * @author nakhoonchoi
 * @date 2024/05/23
 * @see https://www.acmicpc.net/problem/2565
 * @mem 25,100kb
 * @time 160ms
 * @caution
 * [고려사항]
 * LIS 문제이다. start 기준으로 정렬하고 LIS 알고리즘을 이용해서 구하고 N에서 DP배열의 MAX를 빼주었다.
 * 코틀린에서 List와 data class를 사용하는 방법에 대해 알 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DP> '전깃줄'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val electricList: MutableList<ElectricLine> = ArrayList()
    val dp = IntArray(N)

    for(i in 0 until N) {
        val st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        electricList.add(ElectricLine(start, end))
    }

    electricList.sort()

    dp[0] = 1
    for(i in 1 until N){
        dp[i] = 1
        for(j in 0 until i){
            if(electricList[j].end < electricList[i].end){
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
    }

    println(N - dp.max()!!)
}

data class ElectricLine(val start: Int, val end: Int) : Comparable<ElectricLine>{
    override fun compareTo(other: ElectricLine): Int {
        return this.start - other.start
    }
    override fun toString(): String {
        return "ElectricLine(start=$start, end=$end)"
    }
}