/**
 * @author nakhoonchoi
 * @date 2024/05/06
 * @see https://www.acmicpc.net/problem/11720
 * @mem 20,880kb
 * @time 136ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '숫자의 합'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()?.toInt()
    val num = readLine()?.toList()?.map { it.toString().toInt() }
    println(num?.sum())
}