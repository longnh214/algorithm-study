/**
 * @author nakhoon
 * @date Jan 21, 2022
 * @see https://www.acmicpc.net/problem/2294
 * @mem 11,752kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 동전 1과 비슷한 문제였지만 dp 배열 초기화를 잘 시켜주어야 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '동전 2'
public class BOJ2294 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [] coin = new int[N];
		for(int i=0;i<N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int [] dp = new int[K+1];
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		for(int i=0;i<N;i++) {
			for(int j=coin[i];j<=K;j++) {
				dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
			}
		}
		System.out.println(dp[K] == 100001 ? -1 : dp[K]);
	}
}