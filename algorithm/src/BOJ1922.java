/**
 * @author choi
 * @date Sep 5, 2020
 * @see https://www.acmicpc.net/problem/1922
 * @mem 46,220kb
 * @time 360ms
 * @caution
 * [고려사항]
 * Kruskal 알고리즘을 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <최소 스패닝 트리> '네트워크 연결'
public class BOJ1922 {
    static int N,M;
    static long answer;
    static int [] parent,rank;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        PriorityQueue<Connect> pq = new PriorityQueue<>();
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Connect(start, end, cost));
        }

        init();

        int count = 0;
        while(!pq.isEmpty()) {
            Connect temp = pq.poll();

            if(union(temp.start,temp.end)) {
                count++;
                answer += temp.cost;
            }
            if(count == N-1)
                break;
        }

        sb.append(answer);
        System.out.println(sb);
    }

    static void init() {
        parent = new int[N+1];
        rank = new int[N+1];

        for(int i=1;i<=N;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        else
            return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot) return false;
        else {
            if(rank[xRoot] == rank[yRoot])
                rank[xRoot]++;

            if(rank[xRoot] > rank[yRoot])
                parent[yRoot] = parent[xRoot];
            else
                parent[xRoot] = parent[yRoot];
            return true;
        }
    }

    static class Connect implements Comparable<Connect>{
        int start;
        int end;
        int cost;
        public Connect(int start, int end, int cost) {
            super();
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Connect o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}