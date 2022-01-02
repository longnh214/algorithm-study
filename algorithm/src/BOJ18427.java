/**
 * @author nakhoon
 * @date Jan 2, 2022
 * @see https://www.acmicpc.net/problem/18427
 * @mem 13,852kb
 * @time 108ms
 * @caution
 * [고려사항]
 * 평범한 배낭 문제와 비슷한 문제이다. 점화식과 경우의 수를 잘 생각하면 되는 문제다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '함께 블록 쌓기'
public class BOJ18427 {
	static int N,M,H;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int[N+1][H+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int blockCount = st.countTokens(); // 문자열 중 공백으로 split 한 count 개수
			
			dp[i-1][0] = 1; //블록을 사용하지 않는 경우의 수도 존재한다.
			
			for(int j=0;j<blockCount;j++) {
				int block = Integer.parseInt(st.nextToken());
				
				for(int k=block;k<=H;k++) { //현재 블록 크기부터 H까지 순회
					//dp[i][k]의 값도 같이 더해주어야 한다.
					dp[i][k] = (dp[i][k] + dp[i-1][k - block]) % 10007; //이전 학생까지의 블록 현황 dp 에서 현재 학생의 블록 값을 추가했을 때의 값을 저장
				}
			}
			
			for(int j=1;j<=H;j++) {
				dp[i][j] = (dp[i][j] + dp[i-1][j]) % 10007; //그리고 이전 학생까지의 블록 현황 dp 에서 블록을 추가하지 않았을 경우의 수도 생각한다.
			}
		}
		System.out.println(dp[N][H]);
	}
}