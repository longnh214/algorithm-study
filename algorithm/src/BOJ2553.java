/**
 * @author nakhoon
 * @date 2022, 9월 17일
 * @see https://www.acmicpc.net/problem/2553
 * @mem 11,612kb
 * @time 80ms
 * @caution
 * [고려사항]
 * https://steady-coding.tistory.com/322 를 참고해서 DP 형식으로 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '마지막 팩토리얼 수'
public class BOJ2553 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] dp = new int[20001];

        int temp;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 6;
        dp[4] = 4;

        for(int i=5;i<=N;i++){
            if(i % 5 == 0){
                temp = i/5;
                dp[i] = (dp[temp] * (int)Math.pow(2, temp%4))%10;
            }else{
                temp = (i/5)*5;
                dp[i] = dp[temp];
                for(int j=temp+1; j<=i; j++) {
                    dp[i] = dp[i] * j % 10;
                }
            }
        }
        System.out.println(dp[N]);
    }
}