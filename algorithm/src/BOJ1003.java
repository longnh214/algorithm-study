/**
 * @author nakhoon
 * @date Jan 16, 2022
 * @see https://www.acmicpc.net/problem/1003
 * @mem 11,388kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 점화식을 쉽게 만들어 풀 수 있었다. dp의 감을 잊지 않게 위해 간단하게 문제를 풀었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '피보나치 함수'
public class BOJ1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int [][] dp = new int[2][41];
		dp[0][0] = 1;
		dp[1][1] = 1;
		for(int i=2;i<41;i++) {
			dp[0][i] = dp[0][i-1] + dp[0][i-2];
			dp[1][i] = dp[1][i-1] + dp[1][i-2];
		}
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[0][N] + " " + dp[1][N]);
		}
	}
}