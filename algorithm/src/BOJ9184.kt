/**
 * @author nakhoonchoi
 * @date 2024/05/22
 * @see https://www.acmicpc.net/problem/9184
 * @mem 26,032kb
 * @time 620ms
 * @caution
 * [고려사항]
 * 재귀함수에 그대로 메모이제이션을 적용하면 된다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '신나는 함수 실행'
val dp = Array(21) { Array(21) { IntArray(21) { 0 } } }

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    while(true){
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        if(a == -1 && b == -1 && c == -1)
            break

        println("w($a, $b, $c) = ${w(a, b, c)}")
    }
}

fun w(a: Int, b: Int, c: Int): Int{
    if(a <= 0 || b <= 0 || c <= 0){
        return 1
    }
    if(a > 20 || b > 20 || c > 20){
        return w(20, 20, 20)
    }
    if(dp[a][b][c] != 0){
        return dp[a][b][c]
    }
    if(b in (a + 1) until c){
        dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        return dp[a][b][c]
    }

    dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    return dp[a][b][c]
}