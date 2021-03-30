/**
 * @author choi
 * @date Sep 3, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD
 * @mem 82,700kb
 * @time 296ms
 * @caution
 * [고려사항]
 * 처음에는 모든 경우의 수를 다 따져봐야 하는 줄 알고 dfs로 풀었는데,
 * 최소로 연결된 신장트리(MST)를 찾아야 한다는 것을 알고 프림은 아직 익숙하지 않아
 * Kruskal을 이용해서 최소 스패닝 트리를 구성해 풀었다. 
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D4> '하나로'
public class Solution1251 {
    static int N;
    static double e, answer;
    static StringBuilder sb;
    static int [][] islandArr;
    static int [] rank;
    static int [] parent;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1;t<=T;t++) {
            answer = 0;
            sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            rank = new int[N];
            parent = new int[N];
            islandArr = new int[N][2];
            //x좌표 입력.
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                islandArr[i][0] = Integer.parseInt(st.nextToken());
            }
            //y좌표 입력.
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                islandArr[i][1] = Integer.parseInt(st.nextToken());
            }
            e = Double.parseDouble(br.readLine());

            PriorityQueue<Data> pq = new PriorityQueue<>();

            init();
            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    pq.offer(new Data(i,j,calLength(i,j)));
                }
            }
            int count = 0;
            while(!pq.isEmpty()) {
                Data temp = pq.poll();

                if(union(temp.first,temp.second)) {
                    count++;
                    answer += temp.length;
                }

                if(count == N-1) {
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append((Math.round(answer)));
            System.out.println(sb);
        }
    }

    static void init() {
        for(int i=0;i<N;i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    static int find(int x) {
        if(parent[x] == x)
            return x;
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

    static double calLength(int i, int j) {
        return e * Math.pow(Math.sqrt(Math.pow(islandArr[i][1] - islandArr[j][1], 2) + Math.pow(islandArr[i][0] - islandArr[j][0], 2)), 2);
    }


    static class Data implements Comparable<Data>{
        int first;
        int second;
        double length;

        Data(int first, int second, double length){
            this.first = first;
            this.second = second;
            this.length = length;
        }

        @Override
        public int compareTo(Data o) {
            return Double.compare(this.length, o.length);
        }
    }
}