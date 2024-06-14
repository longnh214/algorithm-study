/**
 * @author nakhoonchoi
 * @date 2024/06/14
 * @see https://www.acmicpc.net/problem/1388
 * @mem 12,372kb
 * @time 96ms
 * @caution
 * [고려사항]
 * 코틀린으로 DFS 연습했습니다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DFS> '바닥 장식'
val dx1388 = intArrayOf(1, 0)
val dy1388 = intArrayOf(0, 1)
val woodArr = charArrayOf('|', '-')
var cnt1388 = 0
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val arr = Array(n) { CharArray(m) }
    val visited = Array(n) { BooleanArray(m) }

    for(i in 0 until n){
        arr[i] = readLine().toCharArray()
    }

    for(i in 0 until n){
        for(j in 0 until m){
            if(isIn1388(i, j, n, m) && !visited[i][j]){
                visited[i][j] = true
                cnt1388++
                if(arr[i][j] == '|')
                    dfs1388(i, j, arr, visited, n, m, 0)
                else
                    dfs1388(i, j, arr, visited, n, m, 1)
            }
        }
    }

    println(cnt1388)
}

fun dfs1388(x: Int, y: Int, arr: Array<CharArray>, visited: Array<BooleanArray>, n: Int, m: Int, flag: Int){
    if(isIn1388(x + dx1388[flag], y + dy1388[flag], n, m) && !visited[x + dx1388[flag]][y + dy1388[flag]] && arr[x + dx1388[flag]][y + dy1388[flag]] == woodArr[flag]){
        visited[x + dx1388[flag]][y + dy1388[flag]] = true
        dfs1388(x + dx1388[flag], y + dy1388[flag], arr, visited, n, m, flag)
    }
}

fun isIn1388(x: Int, y: Int, n: Int, m: Int): Boolean {
    return x >= 0 && x < n && y >= 0 && y < m
}