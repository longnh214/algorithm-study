/**
 * @author nakhoonchoi
 * @date 2024/05/01
 * @see https://www.acmicpc.net/problem/1193
 * @mem 12,192kb
 * @time 92ms
 * @caution
 * [고려사항]
 * i는 대각선 별로 묶여진 그룹의 크기, sum은 그 그룹 안에 몇 번째 수가 들어가는 지를 나타내는 변수이다.
 * 대각선 진행 방향에 따라 분수의 값들을 판별한 후 출력하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '분수찾기'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var sum = 0

    for (i in 1 until 10_000_000) {
        if (n in sum + 1..(sum + i)) {
            if (i % 2 == 0) {
                println("${n - sum}/${1 + (sum + i - n)}")
                break
            } else {
                println("${1 + (sum + i - n)}/${n - sum}")
                break
            }
        } else {
            sum += i
        }
    }
}