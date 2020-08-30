/**
 * @author choi
 * @date Aug 30, 2020
 * @see https://www.acmicpc.net/problem/15656
 * @mem 198,412kb
 * @time 620ms
 * @caution
 * [고려사항]
 * 출력을 System.out.println으로 했더니 시간 초과가 나서 BufferedWriter로
 * 출력했더니 제출이 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> - 'N과 M(7)'
public class BOJ15656 {
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

        permutation(0);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permutation(int cnt) throws IOException {
        if(cnt == M) {
            for(int i : temp)
                bw.write(i + " ");
            bw.write("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            temp[cnt] = num[i];
            permutation(cnt+1);
        }
    }
}