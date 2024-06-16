/**
 * @author nakhoonchoi
 * @date 2024/06/16
 * @see https://www.acmicpc.net/problem/11123
 * @mem 20,440kb
 * @time 180ms
 * @caution
 * [고려사항]
 * 4각의 방향을 다 체크해야했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <DFS> '양 한마리... 양 두마리...'
val dx11123 = intArrayOf(1, 0, 0, -1)
val dy11123 = intArrayOf(0, 1, -1, 0)
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for(i in 0 until t){
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        val arr = Array(n) { CharArray(m) }
        val visited = Array(n) { BooleanArray(m) }

        for(i in 0 until n){
            arr[i] = readLine().toCharArray()
        }

        var cnt = 0
        for(i in 0 until n){
            for(j in 0 until m){
                if(arr[i][j] == '#' && !visited[i][j]){
                    cnt++
                    visited[i][j] = true
                    dfs11123(i, j, n, m, arr, visited)
                }
            }
        }
        println(cnt)
    }
}

fun dfs11123(x: Int, y: Int, n: Int, m: Int, arr: Array<CharArray>, visited: Array<BooleanArray>){
    for(i in 0 until 4){
        if(isIn11123(x + dx11123[i], y + dy11123[i], n, m) && arr[x + dx11123[i]][y + dy11123[i]] == '#' && !visited[x + dx11123[i]][y + dy11123[i]]){
            visited[x + dx11123[i]][y + dy11123[i]] = true
            dfs11123(x + dx11123[i], y + dy11123[i], n, m, arr, visited)
        }
    }
}

fun isIn11123(x: Int, y: Int, n: Int, m: Int): Boolean {
    return x >= 0 && x < n && y >= 0 && y < m
}