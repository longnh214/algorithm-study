/**
 * @author nakhoon
 * @date 2024/01/18
 * @see https://www.acmicpc.net/problem/2609
 * @mem 12,228kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*
import java.util.*

//백준 <수학> '최대공약수와 최소공배수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val A = Integer.parseInt(st.nextToken())
    val B = Integer.parseInt(st.nextToken())
    val gcd = getGcd(A, B)

    println(gcd)
    println(A * B / gcd)
}

fun getGcd(a:Int, b: Int):Int{
    var num1 = a
    var num2 = b
    while (num2 > 0) {
        val temp = num1
        num1 = num2
        num2 = temp % num2
    }

    return num1
}