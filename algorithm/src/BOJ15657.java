/**
 * @author choi
 * @date Aug 30, 2020
 * @see https://www.acmicpc.net/problem/15657
 * @mem 23,068kb
 * @time 148ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> - 'N과 M(8)'
public class BOJ15657 {
    static int [] num;
    static boolean [] visited;
    static int [] temp;
    static int N,M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];

        temp = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        permutation(0,0);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permutation(int cnt, int start) throws IOException {
        if(cnt == M) {
            for(int i : temp)
                bw.write(i + " ");
            bw.write("\n");
            return;
        }

        for(int i=start;i<N;i++) {
            temp[cnt] = num[i];
            permutation(cnt+1,i);
        }
    }
}