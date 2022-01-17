/**
 * @author nakhoon
 * @date Jan 17, 2022
 * @see https://www.acmicpc.net/problem/1904
 * @mem 19,376kb
 * @time 104ms
 * @caution
 * [고려사항]
 * dp를 long형으로 선언해야했고, 1이 입력으로 받아졌을 때에 대한 예외처리를 해야했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '01타일'
public class BOJ1904 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long [] dp = new long[N+1];
		if(N == 1) {
			System.out.println(1);
			return;
		}
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=N;i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		System.out.println(dp[N]);
	}
}