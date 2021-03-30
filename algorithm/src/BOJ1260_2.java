/**
 * @author choi
 * @date Aug 4, 2020
 * @see https://www.acmicpc.net/problem/1260
 * @mem 19,240kb
 * @time 192ms
 * @caution
 * [고려사항] 인접 행렬을 이용하는 것보다 인접 리스트를 이용하는 것이 더 빠르다는 것을 알 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DFS/BFS> - 'DFS와 BFS'
public class BOJ1260_2 {
    static int N,M,V;
    static List<Integer> [] graph;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        //graph와 visited의 크기는? 인덱스는 1부터니까 N+1.
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        //각 리스트 배열마다 초기화.
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<Integer>();
        }
        //값을 입력.
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            //양방향 그래프.
            graph[from].add(to);
            graph[to].add(from);
        }
        //오름차순으로 정렬.
        for(int i=1;i<=N;i++) {
            Collections.sort(graph[i]);
        }

        //탐색하러 가기.
        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V);
        sb.append("\n");

        System.out.println(sb);
    }

    static void dfs(int node) {
        //방문 처리 및 사용.
        visited[node] = true;
        sb.append(node).append(" ");
        for(int i : graph[node]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<Integer>();
        visited[node] = true;
        q.offer(node);

        while(!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp).append(" ");
            for(int i : graph[temp]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}