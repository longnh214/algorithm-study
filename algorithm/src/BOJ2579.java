/**
 * @author nakhoon
 * @date Sep 22, 2021
 * @see https://www.acmicpc.net/problem/2579
 * @mem 11,592kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 연속된 세 자리를 접근할 수 없다는 것을 점화식으로 잘 표현해야했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '계단 오르기'
public class BOJ2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N+1];
		int [] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(N == 1) {
			System.out.println(dp[N]);
			return;
		}
		dp[2] = dp[1] + arr[2];
		if(N == 2) {
			System.out.println(dp[N]);
			return;
		}
		
		for(int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
		}
		System.out.println(dp[N]);
	}
}