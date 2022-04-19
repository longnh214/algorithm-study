/**
 * @author nakhoon
 * @date 2022, 4월 19일
 * @see https://www.acmicpc.net/problem/15990
 * @mem 12,120kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 2차원 배열을 통해서 끝의 자리가 1,2,3에 따라 각각 dp를 나누어서 계산했다. 각 수가 오름차순인 것을 생각해서 계산을 해야 정답이 나올 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <DP> '1,2,3 더하기 4'
public class BOJ15989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] dp = new int[10001][4];
        dp[1][1] = 1; //1
        dp[2][1] = 1; //1+1
        dp[2][2] = 1; //2
        dp[3][1] = 1; //1+1+1
        dp[3][2] = 1; //1+2
        dp[3][3] = 1; //3

        for(int i=4;i<=10000;i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int target = Integer.parseInt(br.readLine());
            sb.append(dp[target][1] + dp[target][2] + dp[target][3]).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}