/**
 * @author nakhoonchoi
 * @date 2024/05/13
 * @see https://www.acmicpc.net/problem/6379
 * @mem 58,164kb
 * @time 476ms
 * @caution
 * [고려사항]
 * toString(regex) 와 sumOf 스트림 메소드를 통해 합을 구해서 비교해주었다.
 * split("")의 결과는 앞 뒤에 공백이 들어가기 때문에, 앞 뒤 공백을 제거해주는
 * filter를 추가로 진행해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '싱기한 네자리 숫자'
fun main(args: Array<String>){
    for(i in 1000 until 10000){
        val a = i.toString(12)
        val b = i.toString(16)
        val aSum = a.split("").filter { it.isNotEmpty() }.sumOf { it.toInt(12) }
        val bSum = b.split("").filter { it.isNotEmpty() }.sumOf { it.toInt(16) }
        val originalSum = i.toString().split("").filter { it.isNotEmpty() }.sumOf { it.toInt() }

        if(aSum == bSum && bSum == originalSum){
            println(i)
        }
    }
}