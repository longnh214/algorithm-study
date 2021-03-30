/**
 * @author choi
 * @date Aug 28, 2020
 * @see https://www.acmicpc.net/problem/15649
 * @mem 59,264kb
 * @time 972ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> - 'N과 M(1)'
public class BOJ15649 {
    static int [] num;
    static boolean [] visited;
    static int [] temp;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        temp = new int[M];
        visited = new boolean[N];

        for(int i=0;i<N;i++) {
            num[i] = i+1;
        }

        permutation(0);
    }

    public static void permutation(int cnt) {
        if(cnt == M) {
            for(int i : temp)
                System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[cnt] = num[i];
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }
}