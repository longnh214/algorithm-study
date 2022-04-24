/**
 * @author nakhoon
 * @date 2022, 4월 24일
 * @see https://www.acmicpc.net/problem/17271
 * @mem 11,580kb
 * @time 76ms
 * @caution
 * [고려사항]
 * dp 배열의 길이를 N에 따라 가변적으로 처리하지 말고, 10002개로 처리해야했던 문제이다.
 * 점화식을 만들어서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <DP> '리그 오브 레전설 (Small)'
public class BOJ17271 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] dp = new int[10002];
        final int MOD = 1_000_000_007;

        for(int i=1;i<M;i++){
            dp[i] = 1;
        }
        dp[M] = 2;
        for(int i=M+1;i<=N;i++){
            dp[i] = (dp[i-M] + dp[i-1]) % MOD;
        }

        System.out.println(dp[N] % MOD);
    }
}