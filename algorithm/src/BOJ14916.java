/**
 * @author nakhoon
 * @date 2022, 6월 20일
 * @see https://www.acmicpc.net/problem/14916
 * @mem 12,012kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 점화식을 이용해서 문제를 해결할 수 있었다. dp 값이 0이면 만들 수 없다고 판단해서 -1을 출력해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <DP> '거스름돈'
public class BOJ14916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] dp = new int[100001];
        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 3;
        for(int i=7;i<=100000;i++){
            if(dp[i-2] == 0){
                dp[i] = dp[i-5] + 1;
            }else if(dp[i-5] == 0){
                dp[i] = dp[i-2] + 1;
            }else {
                dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
            }
        }
        int money = Integer.parseInt(br.readLine());
        System.out.println(dp[money] == 0 ? -1 : dp[money]);
    }
}