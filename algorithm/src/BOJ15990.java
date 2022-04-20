/**
 * @author nakhoon
 * @date 2022, 4월 20일
 * @see https://www.acmicpc.net/problem/15990
 * @mem 18,316kb
 * @time 112ms
 * @caution
 * [고려사항]
 * 점화식을 세워서 문제를 해결할 수 있었다. 다만 마지막에 dp 배열의 합을 구하면서 모듈러 연산을 해주지 않아 틀려서 아쉬웠다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <DP> '1,2,3 더하기 5'
public class BOJ15990 {
    public static void main(String[] args) throws IOException{
        final int MOD = 1000000009;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long [][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i=4;i<=100000;i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int target = Integer.parseInt(br.readLine());
            sb.append((dp[target][1] + dp[target][2] + dp[target][3]) % MOD).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}