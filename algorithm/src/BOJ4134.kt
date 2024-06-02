/**
 * @author nakhoonchoi
 * @date 2024/06/02
 * @see https://www.acmicpc.net/problem/4134
 * @mem 13,504kb
 * @time 356ms
 * @caution
 * [고려사항]
 * 4,000,000,000을 입력 받아야 하므로 Long 형으로 입력 받아야해서 틀렸던 문제이다.
 * 에라토스테네스의 체를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
import kotlin.math.sqrt

//백준 <수학> '다음 소수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for (i in 1..t) {
        val n = readLine().toLong()

        if(n == 0L || n == 1L){
            println(2)
            continue
        }

        var j = n
        while (true) {
            var flag = true
            for (k in 2..sqrt(j.toDouble()).toInt()) {
                if (j % k.toLong() == 0L) {
                    flag = false
                    break
                }
            }
            if (flag) {
                println(j)
                break
            }
            j++
        }
    }
}