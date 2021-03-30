/**
 * @author choi
 * @date Sep 5, 2020
 * @see https://www.acmicpc.net/problem/1647
 * @mem 307,024kb
 * @time 1296ms
 * @caution
 * [고려사항]
 * MST를 전부 합치는 것이 아니라 두개까지만 만들면 되므로 count를 N-2까지만 만들고
 * break를 하면 되는 문제.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <최소 스패닝 트리> '도시 분할 계획'
public class BOJ1647 {
    static int N,M;
    static long answer;
    static int [] parent;
    static int [] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Road> pq = new PriorityQueue<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Road(start, end, cost));
        }

        int count = 0;

        while(!pq.isEmpty()) {
            Road temp = pq.poll();

            if(union(temp.start,temp.end)) {
                count++;
                answer+=temp.cost;
            }
            if(count == N-2)
                break;
        }

        System.out.println(answer);
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
        if(x == parent[x]) return x;
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
            if(rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = parent[xRoot];
            }else {
                parent[xRoot] = parent[yRoot];
            }
            return true;
        }
    }

    static class Road implements Comparable<Road>{
        int start;
        int end;
        int cost;
        public Road(int start, int end, int cost) {
            super();
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Road o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}