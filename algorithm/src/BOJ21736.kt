/**
 * @author nakhoonchoi
 * @date 2024/06/13
 * @see https://www.acmicpc.net/problem/21736
 * @mem 67,112kb
 * @time 296ms
 * @caution
 * [고려사항]
 * 코틀린으로 DFS 연습하겠습니다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DFS> '헌내기는 친구가 필요해'

var cnt = 0
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    var startX: Int = 0
    var startY: Int = 0

    val arr = Array(n){ CharArray(m) }
    val visited = Array(n){ BooleanArray(m) }
    for(i in 0 until n){
        arr[i] = readLine().toCharArray()
        if(arr[i].contains('I')){
            startX = i
            startY = arr[i].indexOf('I')
        }
    }

    dfs21738(startX, startY, arr, visited, n, m)

    println(if(cnt == 0) "TT" else cnt)
}

fun dfs21738(x: Int, y: Int, arr: Array<CharArray>, visited: Array<BooleanArray>, n: Int, m: Int){
    if(arr[x][y] == 'X') return
    if(arr[x][y] == 'P') cnt++

    for(i in 0 until 4){
        if(isIn21738(x + dx[i],y + dy[i],n,m) && !visited[x + dx[i]][y + dy[i]]){
            visited[x + dx[i]][y + dy[i]] = true
            dfs21738(x + dx[i], y + dy[i], arr, visited, n, m)
        }
    }
}

fun isIn21738(x: Int, y: Int, n: Int, m: Int): Boolean {
    return x >= 0 && x < n && y >= 0 && y < m
}