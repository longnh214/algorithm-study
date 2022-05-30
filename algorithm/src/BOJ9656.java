/**
 * @author nakhoon
 * @date 2022, 5월 30일
 * @see https://www.acmicpc.net/problem/9656
 * @mem 11,544kb
 * @time 76ms
 * @caution
 * [고려사항]
 * dp를 이용해서 풀 수 있었다. dp 배열의 값이 홀수면 창영이가 이기고, 짝수면 상근이가 이기는 게임이였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <DP> '돌 게임 2'
public class BOJ9656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for(int i=4;i<=N;i++){
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }
        System.out.println(dp[N] % 2 == 0 ? "SK" : "CY");
    }
}