/**
 * @author choi
 * @date Jan 10, 2021
 * @see https://www.acmicpc.net/problem/1967
 * @mem 20,784kb
 * @time 232ms
 * @caution
 * [고려사항]
 * DFS로 해결하고 싶었지만 결국 BFS로 해결하였다.
 * 구글링으로 트리의 지름을 구하는 방법을 찾아서 해결하였는데,
 * 1단계로 루트 로드에서 가장 가중치가 많은 먼 노드를 찾고, 그 노드에서 가중치가 가장 많은 노드를 찾으면 그 합 가중치가 트리의 지름이 된다.
 * 가중치를 기준으로 한 우선순위큐를 이용해 가장 먼 노드와 가중치를 찾을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '트리의 지름'
public class BOJ1967 {
    static int N,sum,farNode;
    static List<Node> [] treeList;
    static boolean [] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        treeList = new ArrayList[N+1];

        for(int i=1;i<=N;i++) {
            treeList[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            treeList[A].add(new Node(B, cost));
            treeList[B].add(new Node(A, cost));
        }

        bfs(1);

        bfs(farNode);

        System.out.println(sum);
    }

    public static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N+1];
        pq.offer(new Node(start,0));
        visited[start] = true;
        while(!pq.isEmpty()) {
            Node temp = pq.poll();

            farNode = temp.destination;
            sum = temp.cost;

            for(Node next : treeList[temp.destination]) {
                if(!visited[next.destination]) {
                    visited[next.destination] = true;
                    pq.offer(new Node(next.destination,temp.cost + next.cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int destination;
        int cost;
        Node(int destination, int cost){
            this.destination = destination;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}