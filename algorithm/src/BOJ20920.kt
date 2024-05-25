/**
 * @author nakhoonchoi
 * @date 2024/05/25
 * @see https://www.acmicpc.net/problem/20920
 * @mem 55,736kb
 * @time 916ms
 * @caution
 * [고려사항]
 * HashMap의 Key, String 타입에 정렬 조건을 주는 것이 아닌 맵 자체에 정렬 조건을 줄 수 있다는 것이 신기했고,
 * 타 문제에 적용해봐야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <정렬> '영단어 암기는 괴로워'

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val map = HashMap<String, Int>()

    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    for(i in 0 until n){
        val word = readLine()
        if(word.length < m) {
            continue
        }
        map.put(word, map.getOrDefault(word, 0) + 1)
    }

    val result = map.entries.sortedWith { o1, o2 ->
        when {
            o1.value != o2.value -> {
                o2.value.compareTo(o1.value)
            }

            o1.key.length != o2.key.length -> {
                o2.key.length - o1.key.length
            }

            else -> {
                o1.key.compareTo(o2.key)
            }
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    result.forEach{
        bw.write("${it.key}\n")
    }
    bw.flush()
    bw.close()
}