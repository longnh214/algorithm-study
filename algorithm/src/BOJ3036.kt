/**
 * @author nakhoonchoi
 * @date 2024/05/16
 * @see https://www.acmicpc.net/problem/3036
 * @mem 12,324kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 최대공약수를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <수학> '링'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = IntArray(N)
    val st = StringTokenizer(readLine())
    for(i in 0 until N){
        arr[i] = st.nextToken().toInt()
    }

    for(i in 1 until N){
        val gcd = gcd3(arr[0], arr[i])
        println("${arr[0]/gcd}/${arr[i]/gcd}")
    }
}

fun gcd3(a: Int, b: Int): Int{
    if(b == 0) return a
    return gcd3(b, a%b)
}