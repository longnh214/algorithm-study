/**
 * @author nakhoon
 * @date 2022, 6월 18일
 * @see https://www.acmicpc.net/problem/16195
 * @mem 22,884kb
 * @time 160ms
 * @caution
 * [고려사항]
 * dp 배열을 초기화 할 때 잘못 초기화 해서 틀린 횟수가 많았던 문제이다.
 * 점화식을 만들어서 문제를 해결 할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <DP> '1,2,3 더하기 9'
public class BOJ16195 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MOD = 1000000009;
        long [][] dp = new long[1001][1001];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        for(int i=3;i<=1000;i++){
            for(int j=2;j<=i;j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % MOD;
            }
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            long sum = 0;
            for(int i=1;i<=second;i++){
                sum = (sum + dp[first][i]) % MOD;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}