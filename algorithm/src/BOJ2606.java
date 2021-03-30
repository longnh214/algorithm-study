/**
 * @author choi
 * @date Aug 30, 2020
 * @see https://www.acmicpc.net/problem/2606
 * @mem 13,124kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 인접리스트와 dfs를 이용하면 이 문제를 풀 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS/BFS> '바이러스'
public class BOJ2606 {
    static List<Integer> [] link;
    static boolean [] visited;
    static int N,M,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        link = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            link[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link[a].add(b);
            link[b].add(a);
        }

        dfs(1);

        System.out.println(count);
    }

    public static void dfs(int a) {
        visited[a] = true;
        for(int temp : link[a]) {
            if(!visited[temp]) {
                count++;
                dfs(temp);
            }
        }
    }
}