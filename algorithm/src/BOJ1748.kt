/**
 * @author nakhoonchoi
 * @date 2024/06/01
 * @see https://www.acmicpc.net/problem/1748
 * @mem 12,132kb
 * @time 88ms
 * @caution
 * [고려사항]
 * n 이하의 모든 1의 자리 수의 개수 + 십의 자리 수의 개수 + 백의 자리 수의 개수 + ... 를 한 것과 같다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '수 이어 쓰기 1'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var sum = 0
    var i = 1

    while (i <= n) {
        sum += (n - i + 1)
        i *= 10
    }

    println(sum)
}