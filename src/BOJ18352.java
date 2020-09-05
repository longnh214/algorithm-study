/**
 * @author choi
 * @date Sep 6, 2020
 * @see https://www.acmicpc.net/problem/18352
 * @mem 311,736kb
 * @time 1,340ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '특정 거리의 도시 찾기'
public class BOJ18352 {
    static int N,M,X,K;
    static List<Integer> [] graph;
    static boolean [] visited;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        pq = new PriorityQueue<>();

        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
        }

        bfs(X);
        if(pq.size() == 0) {
            System.out.println(-1);
            return;
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.offer(i);
        int depth = 0;
        int size;
        while(!q.isEmpty()) {
            size = q.size();
            while(size-->0) {
                int temp = q.poll();
                if(depth==K) {
                    pq.offer(temp);
                }else {
                    for(int next : graph[temp]){
                        if(!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }
            depth++;
        }
    }
}