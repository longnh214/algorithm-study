/**
 * @author choi
 * @date Sep 16, 2020
 * @see https://www.acmicpc.net/problem/1463
 * @mem 17,200kb
 * @time 108ms
 * @caution
 * [고려사항]
 * dp 배열을 이용하면 풀 수 있는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '1로 만들기'
public class BOJ1463 {
    static int [] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;
        for(int i=N;i>=1;i--) {
            dp[i-1] = Math.min(dp[i-1], dp[i]+1);
            if(i%3 == 0) {
                dp[i/3] = Math.min(dp[i/3], dp[i]+1);
            }
            if(i%2 == 0) {
                dp[i/2] = Math.min(dp[i/2], dp[i]+1);
            }
        }

        System.out.println(dp[1]);
    }
}