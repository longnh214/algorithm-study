/**
 * @author choi
 * @date Sep 5, 2020
 * @see https://www.acmicpc.net/problem/14621
 * @mem 19,224kb
 * @time 188ms
 * @caution
 * [고려사항]
 * Kruskal 알고리즘을 이용해서 문제를 해결할 수 있었다.
 * 연결되지 못할 경우에 -1을 출력하는 조건을 읽지 못해 한번 틀렸다.
 * (문제를 잘 읽어야 되겠다.)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <최소 스패닝 트리> '나만 안되는 연애'
public class BOJ14621 {
    static int N,M;
    static long answer;
    static boolean [] gender;
    static int [] parent,rank;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gender = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            if(st.nextToken().equals("M"))
                gender[i] = true;
            else
                gender[i] = false;
        }

        PriorityQueue<Connect> pq = new PriorityQueue<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

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

        if(count != N-1)
            answer = -1;

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

        if(xRoot == yRoot || gender[x] == gender[y]) return false;
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