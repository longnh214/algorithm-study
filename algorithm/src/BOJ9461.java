/**
 * @author nakhoon
 * @date Jan 19, 2022
 * @see https://www.acmicpc.net/problem/9461
 * @mem 11,472kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 문제의 예시를 보고 점화식을 만들어 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '파도반 수열'
public class BOJ9461 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long [] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3;i<=100;i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}