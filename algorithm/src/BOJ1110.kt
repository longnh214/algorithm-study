/**
 * @author nakhoonchoi
 * @date 2024/05/07
 * @see https://www.acmicpc.net/problem/1110
 * @mem 12,204kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 대상 수의 자리 별로 숫자를 구하고,
 * 차례로 사이클을 몇 번 돌렸는 지 do/while 문으로 구했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '더하기 사이클'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine()?.toInt()?: 0
    var cycleNum = num
    var count = 0

    do {
        val a = cycleNum / 10
        val b = cycleNum % 10
        cycleNum = b * 10 + (a + b) % 10
        count++
    }while(num != cycleNum)
    println(count)
}