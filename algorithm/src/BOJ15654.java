/**
 * @author choi
 * @date Aug 9, 2020
 * @see https://www.acmicpc.net/problem/15654
 * @mem 32,080kb
 * @time 252ms
 * @caution
 * [고려사항] 일반적인 순열이였는데, StringBuilder로 출력해야만 통과하는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <순열> 'N과 M(5)'
public class BOJ15654 {
    static int [] temp;
    static int [] num;
    static boolean [] visited;
    static int N,M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        temp = new int[M];
        num = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        perm(0);

        System.out.println(sb);
    }
    public static void perm(int cnt) {
        if(cnt == M) {
            //출력.
            for(int i=0;i<temp.length;i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }else {
            for(int i=0;i<N;i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    temp[cnt] = num[i];
                    perm(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}