/**
 * @author nakhoonchoi
 * @date May 14, 2024
 * @see https://www.acmicpc.net/problem/1647
 * @mem 324,388kb
 * @time 1,160ms
 * @caution
 * [고려사항]
 * MST를 전부 합치는 것이 아니라 두개까지만 만들면 되므로 count를 N-2까지만 만들고
 * break를 하면 되는 문제.
 *
 * 2024-05-14
 * count를 N-2까지 만드는데, break; 조건문을 answer에 가중치를 더하기 전에
 * break;를 해야하는 함정이 있었던 문제.
 *
 * 마을이 총 두 개일 경우에는 연결을 하지 않아도 됨을 생각해야했다.
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

            if(count == N-2)
                break;

            if(union(temp.start,temp.end)) {
                count++;
                answer+=temp.cost;
            }
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
                parent[yRoot] = xRoot;
            }else {
                parent[xRoot] = yRoot;
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