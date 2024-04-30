/**
 * @author nakhoonchoi
 * @date 2024/04/30
 * @see https://www.acmicpc.net/problem/17478
 * @mem 14,904kb
 * @time 120ms
 * @caution
 * [고려사항]
 * 재귀 함수를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <재귀> '재귀함수가 뭔가요?'

val sb = StringBuilder()
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n")
    recursive(n, n)
    println(sb.substring(0, sb.length - 1))
}

fun recursive(start: Int, end: Int){
    val prefix = "____".repeat(end - start)
    sb.append("$prefix\"재귀함수가 뭔가요?\"\n")
    if(start != 0) {
        sb.append("$prefix\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
        sb.append("${prefix}마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
        sb.append("${prefix}그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n")
    }else{
        sb.append("$prefix\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
        sb.append("${prefix}라고 답변하였지.\n")
    }
    if(start == 0) return
    recursive(start - 1, end)
    sb.append("${prefix}라고 답변하였지.\n")
}