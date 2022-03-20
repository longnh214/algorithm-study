/**
 * @author nakhoon
 * @date 2022, 3월 21일
 * @see https://www.acmicpc.net/problem/10826
 * @mem 18,144kb
 * @time 128ms
 * @caution
 * [고려사항]
 * dp를 이용해서 문제를 해결할 수 있었다. 피보나치 수가 10000이 넘어가면 long 형으로도 커버가 불가능하기 때문에
 * BigInteger를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//백준 <DP> '피보나치 수 4'
public class BOJ10826 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger [] dp = new BigInteger[10001];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for(int i=2;i<10001;i++){
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }
}