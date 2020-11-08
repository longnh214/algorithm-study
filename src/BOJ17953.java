/**
 * @author choi
 * @date Nov 8, 2020
 * @see https://www.acmicpc.net/problem/17953
 * @mem 109,384kb
 * @time 580ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '디저트'
public class BOJ17953 {
    static int N, M;
    static int [][] dessert;
    static long [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dessert = new int[M][N+1];
        dp = new long[M][N+1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                dessert[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=1;i<=N;i++) {
            for(int j=0;j<M;j++) {
                long temp = 0;
                for(int k=0;k<M;k++) {
                    if(i!= 1 && k == j)
                        temp = Math.max(temp, dp[k][i-1] + (dessert[j][i] / 2));
                    else
                        temp = Math.max(temp, dp[k][i-1] + dessert[j][i]);
                }
                dp[j][i] = temp;
            }
        }

        long answer = Long.MIN_VALUE;

        for(int i=0;i<M;i++) {
            answer = Math.max(answer, dp[i][N]);
        }
        System.out.println(answer);
    }
}