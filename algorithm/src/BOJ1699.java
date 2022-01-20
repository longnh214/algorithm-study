/**
 * @author nakhoon
 * @date Jan 20, 2022
 * @see https://www.acmicpc.net/problem/1699
 * @mem 12,776kb
 * @time 156ms
 * @caution
 * [고려사항]
 * dp[N] = N 으로 초기화를 해두고, dp[N - 제곱수] + 1 과 dp[N]의 최소를 비교해서 저장해주면 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '제곱수의 합'
public class BOJ1699 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long [] dp = new long[100001];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {
			dp[i] = i;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j*j<=i;j++) {
				dp[i] = Math.min(dp[i - (j * j)] + 1, dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}