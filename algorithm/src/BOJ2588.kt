/**
 * @author nakhoon
 * @date 2024/1/16
 * @see https://www.acmicpc.net/problem/2588
 * @mem 25,984kb
 * @time 188ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <입출력> '곱셈'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val a = readLine()?.toInt() ?: 0
    val b = readLine()
    b?.let {
        val reversedDigits = it.reversed().split("").filter { it.isNotBlank() }
        for (digit in reversedDigits) {
            println(a * digit.toInt())
        }
    }
    println(a * Integer.parseInt(b))
}