/**
 * @author naknak
 * @date 2/4/24
 * @see https://www.acmicpc.net/problem/25304
 * @mem 12,300kb
 * @time 88ms
 * @caution
 * [고려사항]
 * kotlin에는 삼항 연산자가 없기 때문에 if(조건문) a else b 로
 * 삼항 연산자처럼 사용할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*
import java.io.*

//백준 <반복문> '영수증'
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val receipt = readLine().toInt()
    val speciesCount = readLine().toInt()
    var sum = 0

    for(i in 1..speciesCount){
        val st = StringTokenizer(readLine())
        val money = st.nextToken().toInt()
        val count = st.nextToken().toInt()

        sum += (money * count)
    }

    println(if(sum == receipt) "Yes" else "No")
}