/**
 * @author nakhoon
 * @date Feb 20, 2022
 * @see https://www.acmicpc.net/problem/13398
 * @mem 24,124kb
 * @time 200ms
 * @caution
 * [고려사항]
 * 한번 skip을 한 경우와 skip을 한번도 하지 않은 경우로 나누어서 계산을 했다.
 * dp[i][0] = Math.max(dp[i-1][0] + cur, cur);
 * -> skip 하지 않은 경우는 이전까지 스킵하지 않은 경우의 수에서 현재 수를 더한 값과 현재 수 중 더 큰 값을 배열에 넣어주었다.
 * dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + cur);
 * -> skip을 한 경우는 skip을 했기 때문에 이전의 스킵하지 않은 값과 이전의 스킵 카운트를 소모한 수에서 현재 수를 더한 값
 * 중 더 큰 수를 배열에 넣어주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '연속합 2'
public class BOJ13398 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] dp = new int[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = dp[0][0] = dp[0][1] = Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++) {
			int cur = Integer.parseInt(st.nextToken());
			dp[i][0] = Math.max(dp[i-1][0] + cur, cur);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + cur);
			answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
		}
		System.out.println(answer);
	}
}