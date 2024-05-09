/**
 * @author nakhoonchoi
 * @date 2024/05/09
 * @see https://www.acmicpc.net/problem/1735
 * @mem 12,196kb
 * @time 88ms
 * @caution
 * [고려사항]
 * A * B / GCD(최대공약수) = GCM(최소공배수) 공식을 이용해서
 * 분수의 합을 구하고, 약분을 하기 위해 GCD(최대공약수)를 구해서 약분해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '분수 합'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val upA = st.nextToken().toInt()
    val downA = st.nextToken().toInt()

    st = StringTokenizer(readLine())
    val upB = st.nextToken().toInt()
    val downB = st.nextToken().toInt()

    val gcd = gcd(downA, downB)
    val gcm = downA * downB / gcd

    val upC = upA * (gcm / downA) + upB * (gcm / downB)

    val nextGcd = gcd(upC, gcm)

    println("${upC / nextGcd} ${gcm / nextGcd}")
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}