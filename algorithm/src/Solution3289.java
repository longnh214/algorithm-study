/**
 * @author choi
 * @date Aug 4, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
 * @mem 125,324 kb
 * @time 981 ms
 * @caution
 * [고려사항] 배열로 서로소 집합을 하려했으나 시간 초과로 인해 틀린 것 같다.
 * [입력사항]
 * [출력사항] 이상하게 stringbuilder로 출력하려니 틀렸다.
 */
import java.io.*;
import java.util.*;
// SW expert <D4> - '서로소 집합'
public class Solution3289 {
    static int N, M, number[], rank[];//단계를 정의하는 rank

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            //StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            makeSet();
            System.out.printf("#%d ",t);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cmd == 0) {
                    union(a,b);
                } else {
                    System.out.printf(find(a) == find(b) ? "1" : "0");
                }
            }
            System.out.println();
        }
    }

    static void makeSet() {
        number = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            number[i] = i;
            rank[i] = 1;
        }
    }

    static int find(int x) {
        if (number[x] == x) {
            return x;
        } else {
            //path compression
            return number[x] = find(number[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        //rank union 적용
        if(x != y) {
            if(rank[x] == rank[y]) {
                rank[x]++;
            }
            //rank가 작은 녀석을 큰 녀석에게 붙여주자.
            if(rank[x] > rank[y]) {
                number[y] = x;
            }else {
                number[x] = y;
            }
        }
    }
}