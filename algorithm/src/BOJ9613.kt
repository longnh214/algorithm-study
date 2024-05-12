/**
 * @author nakhoonchoi
 * @date 2024/05/12
 * @see https://www.acmicpc.net/problem/9613
 * @mem 12,268kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 합계가 int 형을 벗어날 수 있었던 문제이다.
 * 조합으로 풀려고 했지만, 이중 for문을 이용해서 쌍마다 최대공약수를 구해주었는데, 다음 문제는 조합 문제를 코틀린으로 연습해봐야겠다.
 *
 * gcd로 함수명을 하고 싶었지만 함수명이 겹치므로 함수명을 임의로 바꿔주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> 'GCD 합'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var t = readLine().toInt()
    while(t-- > 0) {
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val arr = IntArray(n)
        for(i in 0 until n) {
            arr[i] = st.nextToken().toInt()
        }
        var sum: Long = 0
        for(i in 0 until n) {
            for(j in i+1 until n) {
                sum += gcd2(arr[i], arr[j])
            }
        }
        println(sum)
    }
}

fun gcd2(a: Int, b: Int): Int{
    if(b == 0) return a
    return gcd2(b, a%b)
}