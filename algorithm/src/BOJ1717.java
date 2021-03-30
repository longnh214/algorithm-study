/**
 * @author choi
 * @date Jan 12, 2021
 * @see https://www.acmicpc.net/problem/1717
 * @mem 56,924kb
 * @time 1884ms
 * @caution
 * [고려사항]
 * 분리 집합 문제를 오랜만에 풀어서 조금 시간이 걸렸다.
 * 39번 줄 if문 조건을 (parent[a] == parent[b])에서 (find(a) == find(b))으로 바꾸니 해결할 수 있었다.
 * find()연산을 해주면서 집합이 갱신되어서 parent가 아닌 find()연산 값을 비교해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <분리집합(union-find)> '집합의 표현'
public class BOJ1717 {
    static int [] parent,rank;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        init();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd == 0) {
                union(a,b);
            }else {
                if(find(a) == find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    public static void init() {
        parent = new int[N+1];
        rank = new int[N+1];
        for(int i=0;i<parent.length;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        else {
            return parent[x] = find(parent[x]);
        }
    }

    public static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB)
            return false;
        else {
            if(rank[parentA] == rank[parentB])
                rank[parentA]++;

            if(rank[parentA] > rank[parentB])
                parent[parentB] = parent[parentA];
            else
                parent[parentA] = parent[parentB];

            return true;
        }
    }
}