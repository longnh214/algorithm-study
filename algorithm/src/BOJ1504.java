/**
 * @author choi
 * @date Jan 13, 2021
 * @see https://www.acmicpc.net/problem/1504
 * @mem 69,388kb
 * @time 712ms
 * @caution
 * [고려사항]
 * 인접리스트를 이용했고, 우선 INF를 2억으로 준 이유는 간선의 개수가 최대 20만이고, cost의 최대는 1000이기 때문에
 * cost의 최대값은 2억을 넘을 수 없습니다.(한 번의 다익스트라 기준.)
 * 인접리스트를 이용하면서 visited 배열을 안 쓰고 해결하고 싶었는데,
 * 인접 배열을 이용하게 되면 dist 배열이 초기화가 되지 않으므로 visited가 필요없지만,
 * 인접 리스트를 이용하게 되면 visited 처리를 해주어야한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <다익스트라> '특정한 최단 경로'
public class BOJ1504 {
    static final int INF = 200000000;
    static List<Node> [] adjList;
    static int [] essential;
    static int N, E;
    static int [] dist;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        essential = new int[2];
        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N;i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b,cost));
            adjList[b].add(new Node(a,cost));
        }

        //필수로 지나야 하는 노드의 번호를 입력.
        st = new StringTokenizer(br.readLine());
        essential[0] = Integer.parseInt(st.nextToken());
        essential[1] = Integer.parseInt(st.nextToken());


        //result1의 경우 1 -> essential[0] -> essential[1] -> N
        //result2의 경우 1 -> essential[1] -> essential[0] -> N
        int result1 = 0;
        int result2 = 0;

        result1 += bfs(1, essential[0]);
        result1 += bfs(essential[0],essential[1]);
        result1 += bfs(essential[1],N);

        result2 += bfs(1, essential[1]);
        result2 += bfs(essential[1],essential[0]);
        result2 += bfs(essential[0],N);

        //result1과 2 둘 다 INF 이상이라면, 1에서 N으로 가는 경로는 없는 것입니다.
        if(result1 >= INF && result2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(result1, result2));
    }

    //우선순위큐를 사용한 bfs = 다익스트라(?)
    public static int bfs(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        //dist 배열과 visited 배열 초기화
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node temp = pq.poll();

            //그리고 다익스트라는 visited 처리 시점이 bfs와 다르다.
            //현재 poll된 노드를 다시 돌아오게 된다면 무조건 가중치가 높아질 것이기 때문이다.
            if(visited[temp.dest]) continue;
            visited[temp.dest] = true;

            for(Node next : adjList[temp.dest]) {
                if(!visited[next.dest] && dist[next.dest] > temp.cost + next.cost) {
                    dist[next.dest] = temp.cost + next.cost;
                    pq.offer(new Node(next.dest,temp.cost + next.cost));
                }
            }
        }

        return dist[end];
    }

    public static boolean isVisited() {
        for(int i=0;i<2;i++) {
            if(!visited[essential[i]])
                return false;
        }
        return true;
    }

    static class Node implements Comparable<Node>{
        int dest;
        int cost;
        Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}