/**
 * @author nakhoon
 * @date Sep 27, 2021
 * @see https://www.acmicpc.net/problem/1937
 * @mem 41,728kb
 * @time 472ms
 * @caution
 * [고려사항]
 * dfs + 메모이제이션을 이용해서 푼 문제이다. 메모이제이션을 이용하면 visited 배열을 굳이 만들 필요가 없어진다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS/DP> '욕심쟁이 판다'
public class BOJ1937 {
	static int N;
	static int [][] dp;
	static int [][] arr;
	static int answer;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		dp = new int[N][N];
		StringTokenizer st;
		answer = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dfs(i,j);
			}
		}
		System.out.println(answer);
	}
	
	public static int dfs(int x, int y) {
		if(dp[x][y] != Integer.MAX_VALUE) return dp[x][y];
		
		int max = 0;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isIn(nx,ny) && arr[x][y] < arr[nx][ny]) {
				max = Math.max(max, dfs(nx,ny) + 1);
			}
		}
		
		if(max == 0) {
			dp[x][y] = 1;
			answer = Math.max(answer, dp[x][y]);
			return 1;
		}
		else {
			dp[x][y] = max;
			answer = Math.max(answer, dp[x][y]);
			return max;
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N; 
	}
}