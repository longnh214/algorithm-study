/**
 * @author nakhoon
 * @date 2022, 7월 20일
 * @see https://www.acmicpc.net/problem/17212
 * @mem 12,176kb
 * @time 96ms
 * @caution
 * [고려사항]
 * DP를 이용해서 문제를 해결할 수 있었다. 최소의 개수로 해당 금액을 만드는 경우의 수를 찾는 문제이기에
 * Math.min을 이용해서 1,2,5,7을 뺀 동전의 경우의 수 중 가장 최소 + 1을 경우의 수로 구해야했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '달나라 토끼를 위한 구매대금 지불 도우미'
public class BOJ17212 {
    static final int [] coin = {1,2,5,7};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for(int i=1;i<=N;i++){
            for(int j=0;j<4;j++){
                if(i>=coin[j])
                    dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}