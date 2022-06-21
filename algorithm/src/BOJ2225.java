/**
 * @author nakhoon
 * @date 2022, 6월 21일
 * @see https://www.acmicpc.net/problem/2225
 * @mem 12,748kb
 * @time 120ms
 * @caution
 * [고려사항]
 * 0부터 N까지 수 중 K개의 합으로 N을 만들어야 했기 때문에 0의 경우에도 계산을 해주어야 했다. 초기화를 하고
 * dp[N][K] = dp[0][K-1] + dp[1][K-1] + ... + dp[N][K-1] 로 점화식을 세웠다.
 * 그리고 int 범위가 벗어나는 경우의 수가 있어 long 형으로 선언했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <DP> '합분해'
public class BOJ2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        final int mod = 1000000000;

        long[][] dp = new long[N+1][K+1];

        for (int i=0;i<2;i++) {
            for (int j=1;j<=K;j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = j;
                }
            }
        }

        for (int i=0;i<=N;i++) {
            dp[i][1] = 1;
        }

        for (int i=2;i<=N;i++) {
            for (int j=2;j<=K;j++) {
                for (int k=i;k>=0;k--) {
                    dp[i][j] += dp[k][j - 1] % mod;
                }
            }
        }

        System.out.println(dp[N][K] % mod);
    }
}