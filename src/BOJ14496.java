/**
 * @author choi
 * @date Sep 6, 2020
 * @see https://www.acmicpc.net/problem/14496
 * @mem 19,008kb
 * @time 168ms
 * @caution
 * [고려사항]
 * 다익스트라처럼 distance 배열을 만들어서 모든 경우의 수를 돌며
 * 갈 수 있는 모든 경우의 수를 돌아보며 최소값으로 갱신해주어 마지막으로 distance[b]의 값을 출력한.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '그대, 그머가 되어'
public class BOJ14496 {
    static int a,b,N,M;
    static List<Integer> [] graph;
    static int [] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(a == b) {
            System.out.println(0);
            return;
        }

        graph = new ArrayList[N+1];
        distance = new int[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        bfs(a);
        System.out.println(distance[b] == Integer.MAX_VALUE ? -1 : distance[b]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        distance[start] = 0;
        q.offer(start);

        while(!q.isEmpty()) {
            int temp = q.poll();

            for(int next : graph[temp]) {
                if(distance[next] > distance[temp] + 1) {
                    distance[next] = distance[temp] + 1;
                    q.offer(next);
                }
            }
        }

    }
}