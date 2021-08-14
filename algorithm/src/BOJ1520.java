/**
 * @author nakhoon
 * @date Aug 15, 2021
 * @see https://www.acmicpc.net/problem/1520
 * @mem 38,736kb
 * @time 324ms
 * @caution
 * [고려사항]
 * 마지막까지 찍고 돌아온 것을 dp에 저장하여 마지막에 0,0의 메모이제이션 값을 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS>'내리막 길'
public class BOJ1520 {
	static int N,M;
	static int [][] arr;
	static int [][] dp;
	static int [] dx=  {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		dp = new int[M][N];
		
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	public static int dfs(int x, int y) {
		if(x==M-1 && y == N-1) {
			return 1;
		}
		
		if(dp[x][y] == -1) {
			dp[x][y]++;
			
			for(int i=0;i<4;i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				
				if(isIn(nx,ny) &&  arr[x][y] > arr[nx][ny]) {
					dp[x][y] += dfs(nx,ny);
				}
			}
		}
		return dp[x][y];
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}
}