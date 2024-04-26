/**
 * @author nakhoonchoi
 * @date 2024/04/26
 * @see https://www.acmicpc.net/problem/10158
 * @mem 12,216kb
 * @time 88ms
 * @caution
 * [고려사항]
 * x좌표와 y좌표를 따로 생각해서, 계산식을 구해야했던 문제이다.
 * 정방향인지 역방향인지 고려해서 따로 좌표를 구해서 출력해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*
import java.util.*

//백준 <수학> '개미'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    st = StringTokenizer(readLine())
    var p = st.nextToken().toInt()
    var q = st.nextToken().toInt()
    val t = readLine().toInt()

    p = if ((p + t) / w % 2 == 0) {
        (p + t) % w
    } else {
        w - (p + t) % w
    }

    q = if ((q + t) / h % 2 == 0) {
        (q + t) % h
    } else {
        h - (q + t) % h
    }

    val answer = StringBuilder()

    answer.append("$p $q")

    print(answer)
}