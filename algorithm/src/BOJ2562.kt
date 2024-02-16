/**
 * @author naknak
 * @date 2/16/24
 * @see https://www.acmicpc.net/problem/2562
 * @mem 12,236kb
 * @time 92ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <배열> '최댓값'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var max = Integer.MIN_VALUE
    var index = 0

    for(i in 1 .. 9){
        val num = readLine().toInt()

        if(num > max){
            index = i
            max = num
        }
    }

    bw.write(max.toString())
    bw.write("\n")
    bw.write(index.toString())

    bw.flush()
    bw.close()
}