/**
 * @author nakhoonchoi
 * @date 2024/04/27
 * @see https://www.acmicpc.net/problem/25257
 * @mem 31,564kb
 * @time 416ms
 * @caution
 * [고려사항]
 * 해시맵과 코틀린의 when(switch)문법, String List의 스트림을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <해시맵> '임스와 함께하는 미니게임'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val game = when(st.nextToken()){
                "Y" -> 2
                "F" -> 3
                "O" -> 4
                else -> 0
            }
    val player = ArrayList<String>()

    for(i in 1..N){
        player.add(readLine())
    }

    println(player.stream()
        .distinct()
        .count()
        .toInt() / (game - 1)
    )
}