/**
 * @author choi
 * @date Sep 23, 2020
 * @see https://www.acmicpc.net/problem/2193
 * @mem 12,960kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '이친수'
public class BOJ2193 {
    static long [][] dp = new long[91][2];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[1][1] = 1;

        for(int i=2;i<N+1;i++) {
            dp[i][0] += dp[i-1][0];
            dp[i][0] += dp[i-1][1];

            dp[i][1] += dp[i-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}