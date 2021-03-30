/**
 * @author choi
 * @date Sep 23, 2020
 * @see https://www.acmicpc.net/problem/10844
 * @mem 12,988kb
 * @time 80ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '쉬운 계단 수'
public class BOJ10844 {
    static long [][] dp = new long[10][101];
    static long mod = 1000000000;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=1;i<10;i++) {
            dp[i][1] = 1;
        }

        for(int i=2;i<=N;i++) {
            for(int j=0;j<10;j++) {
                //dp[i][j] = 0;
                if(j-1 >= 0) {
                    dp[j][i] += dp[j-1][i-1];
                }
                if(j+1 <= 9) {
                    dp[j][i] += dp[j+1][i-1];
                }
                dp[j][i] %= mod;
            }
        }

        long answer = 0;

        for(int i=0;i<10;i++) {
            answer += dp[i][N];
        }

        answer %= mod;

        System.out.println(answer);
    }
}