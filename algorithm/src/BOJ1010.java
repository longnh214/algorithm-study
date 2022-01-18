/**
 * @author nakhoon
 * @date Jan 18, 2022
 * @see https://www.acmicpc.net/problem/1010
 * @mem 12,344kb
 * @time 108ms
 * @caution
 * [고려사항]
 * n+1Cm+1 = nCm + nCm+1 과 nCn = nC0 = 1의 조합 특성을 가지고 점화식을 만들어서 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '다리 놓기'
public class BOJ1010 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int [][] dp = new int[30][30];
		
		for(int i=0;i<30;i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;	
		}
		
		for(int i=2;i<30;i++) {
			for(int j=1;j<30;j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(dp[M][N]);
		}
	}
}