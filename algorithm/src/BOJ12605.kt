/**
 * @author nakhoon
 * @date 2024/1/19
 * @see https://www.acmicpc.net/problem/12605
 * @mem 20,472kb
 * @time 124ms
 * @caution
 * [고려사항]
 * 마지막에 공백을 출력해야하는 것을 모르고 String의 join함수를 썼지만 공백이 없어 WA를 받았다.
 * StringBuilder를 통해 한 번에 출력하는 방식으로 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = Integer.parseInt(readLine())

    val sb = StringBuilder()

    for(i in 0 until size) {
        val strList: List<String> = readLine().split(" ").reversed()

        sb.append("Case #${i+1}: ")
        for(str in strList){
            sb.append(str).append(" ")
        }
        sb.append("\n")
    }

    println(sb)
}