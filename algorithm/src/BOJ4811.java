/**
 * @author nakhoon
 * @date Oct 1, 2021
 * @see https://www.acmicpc.net/problem/4811
 * @mem 11,700kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 점화식 세우는 데 오래 걸렸던 문제이다.
 * 
 * N이 1일 때,
 * WH로 (알약 전체 한 알을 뽑고 반을 집어넣고, 마지막으로 반을 뽑는다. - 총 2 번) 경우의 수가 딱 한 가지
 * dp[1] = 1;
 * 
 * N이 2일 때,
 * 첫번째 알약 전체를 뽑은 이후의 경우의 수는, (반 알, 전체 한 알 순서, 전체 한 알, 반 알 순서)로 총 두 가지이다.
 * dp[2] = 2;
 * 
 * N이 3일 때 이후부터 점화식을 세울 수 있다.
 * 
 * 먼저 첫 번째 경우의 수는, 똑같이 첫 번째 알약 한 알을 뽑은 이후를 생각해보면, 
 * 1. 한 알, 한 알, 반 알 (... 뒤의 반 알 두번은 생략)
 * - 점화식 dp[2] * dp[0]
 *
 * 2. 한 알, 반 알, 반 알 (... 뒤 생략)
 * - 점화식 dp[1] * dp[1]
 * 
 * 3. 반 알, 한 알, 한 알 (... 뒤 생략)
 * - 점화식 dp[0] * dp[2]
 * 
 * 으로 총 세 가지이다.
 * 
 * 점화식을 생각한 것은 경우의 수를 봤을 때, 반 알 기준으로 왼 편의 한 알을 뽑는 횟수 * 오른 편의 한 알을 뽑는 횟수로 생각하면 맞다.
 *
 * for j in (0,i)
 * 		dp[i] += (dp[j] * dp[i-j-1]);
 * 
 * 로 점화식을 세울 수 있을 것이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '알약'
public class BOJ4811 {
	static long [] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new long[31];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=30;i++) {
			long total = 0;
			
			for(int j=0;j<i;j++) {
				total += (dp[j] * dp[i-j-1]);
			}
			
			dp[i] = total;
		}
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			sb.append(dp[N] + "\n");
		}
		
		System.out.println(sb.substring(0,sb.length()-1));
	}
}