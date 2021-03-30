/**
 * @author choi
 * @date Aug 28, 2020
 * @see https://www.acmicpc.net/problem/15651
 * @mem 279,680kb
 * @time 604ms
 * @caution
 * [고려사항]
 * 정상적으로 system.out으로 출력하려면 계속 시간 초과 나서 사이트를 참조하여
 * Buffer를 이용해 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> 'N과 M(3)'
public class BOJ15651 {
    static int [] temp;
    static int [] num;
    static boolean [] visited;
    static int N,M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        temp = new int[M];
        num = new int[N+1];
        for(int i=1;i<=N;i++) {
            num[i] = i;
        }
        perm(0);
        bw.flush();
        bw.close();
    }
    public static void perm(int cnt) throws IOException {
        if(cnt == M) {
            StringBuilder sb = new StringBuilder();
            //출력.
            for(int i=0;i<temp.length;i++) {
                String str = String.valueOf(temp[i]);
                bw.write(str + ' ');
            }
            bw.write("\n");
            return;
        }

        for(int i=1;i<=N;i++) {
            temp[cnt] = num[i];
            perm(cnt+1);
        }
    }
}