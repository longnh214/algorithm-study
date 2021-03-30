/**
 * @author choi
 * @date Aug 9, 2020
 * @see https://www.acmicpc.net/problem/15650
 * @mem 13,880kb
 * @time 116ms
 * @caution
 * [고려사항] 오름차순인 순열만 출력하려면 조합처럼 start 매개 변수로 두면 쉽게 출력이 가능하다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <순열> 'N과 M(2)'
public class BOJ15650 {
    static int [] temp;
    static int [] num;
    static boolean [] visited;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        temp = new int[M];
        num = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            num[i] = i;
        }
        perm(0,1);
    }
    public static void perm(int cnt, int start) {
        if(cnt == M) {
            //출력.
            for(int i=0;i<temp.length;i++) {
                System.out.printf("%d ",temp[i]);
            }
            System.out.println();
            return;
        }

        for(int i=start;i<=N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[cnt] = num[i];
                perm(cnt+1,i+1);
                visited[i] = false;
            }
        }
    }
}