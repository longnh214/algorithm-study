/**
 * @author nakhoonchoi
 * @date 2024/08/18
 * @see https://www.acmicpc.net/problem/17626
 * @mem 11,800kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 현재 수에서 제곱수를 뺀 dp 값 + 1 중 가장 최솟값을 현재 dp에 메모이제이션 해놓으면 되는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DP> 'Four Squares'

public class BOJ17626 {
    public static void main(String[] args) throws IOException{
        int [] dp = new int[50001];

        dp[1] = 1;

        int min = 0;
        for(int i=2;i<=50000;i++){
            min = Integer.MAX_VALUE;

            for(int j=1;j*j <= i;j++){
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min + 1;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(dp[N]);
    }
}