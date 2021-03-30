/**
 * @author choi
 * @date Sep 1, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb
 * @mem 113,308kb
 * @time 2,080ms
 * @caution
 * [고려사항]
 * answer이 int형을 벗어날 수 있으므로 long 형으로 선언했어야하는 주의 사항이 있었고,
 * 백준 알고리즘 사이트와 다르게 테스트케이스마다 answer를 0으로 초기화를 해주지 않아 계속 틀렸다.
 * 그리고 선택한 간선이 V-1개면 끝내야 한다는 것을 넣지 않았었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW expert <D4> - '최소 스패닝 트리'
public class Solution3124 {
    static int [] parent, rank;
    static int V,E;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            for(int i=0;i<E;i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                pq.offer(new Edge(start,end,cost));
            }

            init();
            int count = 0;
            while(!pq.isEmpty()) {
                Edge temp = pq.poll();

                if(union(temp.start, temp.end)) {
                    answer+=temp.cost;
                }
                if(count == V-1) break;
            }
            System.out.println("#"+t+" " +answer);
        }
    }

    public static void init() {
        parent = new int[V+1];
        rank = new int[V+1];

        for(int i=1;i<V;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public static int find(int n) {
        if(parent[n] == n) return n;
        else {
            return parent[n] = find(parent[n]);
        }
    }

    public static boolean union(int a,int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) {
            return false;
        }else {
            if(rank[parentA] == rank[parentB]) {
                rank[parentA]++;
            }

            if(rank[parentA] > rank[parentB]){
                parent[parentB] = parent[parentA];
            }else {
                parent[parentA] = parent[parentB];
            }
            return true;
        }
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;
        public Edge(int start, int end, int cost) {
            super();
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.cost, o.cost);
        }
    }
}