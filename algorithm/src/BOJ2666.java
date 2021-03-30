/**
 * @author choi
 * @date Dec 29, 2020
 * @see https://www.acmicpc.net/problem/2666
 * @mem 11,436kb
 * @time 80ms
 * @caution
 * [고려사항]
 * dp로 분류되어 있어서 어려웠던 문제로 옛날부터 풀지 못했던 문제지만, 완전탐색 dfs를 이용하여 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS/DP> '벽장문의 이동'
public class BOJ2666 {
    static int N, M, answer;
    static int [] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        visited = new int[M];

        for(int i=0;i<M;i++) {
            visited[i] = Integer.parseInt(br.readLine());
        }

        answer = N * M + 1;
        dfs(first,second,0,0);
        System.out.println(answer);
    }

    public static void dfs(int first, int second, int depth, int moveCnt) {
        // 분기한정
        if (moveCnt > answer) return;

        if (depth == M) {
            answer = Math.min(answer, moveCnt);
            return;
        }
        dfs(visited[depth], second, depth + 1, moveCnt + Math.abs(first - visited[depth]));
        dfs(first, visited[depth], depth + 1, moveCnt + Math.abs(second - visited[depth]));
    }
}