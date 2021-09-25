/**
 * @author nakhoon
 * @date Sep 26, 2021
 * @see https://www.acmicpc.net/problem/2156
 * @mem 13,016kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 계단 오르기와 비슷한 문제라고 생각되었지만, 조건이 달랐다.
 * 맨 마지막 포도주를 마시지 않아도 된다는 점이 달랐고, 꼭 한번 마셨을 때 연속으로 다음 것을 안 마셔도 됐었다.
 * dp의 값을 계산 해야할 때, dp[i-3] + arr[i-1] + arr[i] , dp[i-4] + arr[i-1] + arr[i], dp[i-2] + arr[i] 세 가지 중에 최대값으로 정해야 했다.
 * (즉, 두 번 건너뛸 경우의 수도 존재한다.)
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '포도주 시식'
public class BOJ2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N+1];
		int [] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int answer = Integer.MIN_VALUE;
		
		dp[1] = arr[1];
		answer = Math.max(answer, dp[1]);
		if(N == 1) {
			System.out.println(answer);
			return;
		}
		
		dp[2] = arr[2] + arr[1];
		answer = Math.max(answer, dp[2]);
		if(N == 2) {
			System.out.println(answer);
			return;
		}
		
		dp[3] = arr[3]  + Math.max(dp[1], dp[0] + arr[2]);
		answer = Math.max(answer, dp[3]);
		if(N == 3) {
			System.out.println(answer);
			return;
		}
		
		for(int i=4;i<=N;i++) {
			dp[i] = arr[i] + Math.max(dp[i-2], Math.max(dp[i-3] + arr[i-1], dp[i-4] + arr[i-1]));
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}