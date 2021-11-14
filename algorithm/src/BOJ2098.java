/**
 * @author nakhoon
 * @date Nov 15, 2021
 * @see https://www.acmicpc.net/problem/2098
 * @mem 17,080kb
 * @time 164ms
 * @caution
 * [고려사항]
 * dp와 비트마스킹을 이용해 풀 수 있는 문제였다.
 * 최대값을 Integer.MAX_VALUE로 설정하면 틀릴 수 있었다. 최대값을 정할 때에 실제로 나올 수 있는 최대값으로 설정해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <비트마스킹,DP> '외판원 순회'
public class BOJ2098 {
	static int [][] arr;
	static int [][] dp;
	static int N;
	static final int INF = 16000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		dp = new int[N][(1 << N)-1];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], INF);
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(0,1));
	}
	
	public static int dfs(int city, int visit) {
		if(visit == (1<<N)-1) {
			if(arr[city][0] == 0) {
				return INF;
			}
			return arr[city][0];
		}
		
		if(dp[city][visit] != INF) {
			return dp[city][visit];
		}
		for(int i=0;i<N;i++) {
			if((visit & (1 << i)) == 0 && arr[city][i] != 0) {
				dp[city][visit] = Math.min(dp[city][visit], dfs(i, visit | (1 << i)) + arr[city][i]);
			}
		}
		return dp[city][visit];
	}
}