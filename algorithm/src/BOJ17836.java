/**
 * @author nakhoon
 * @date Jul 3, 2021
 * @see https://www.acmicpc.net/problem/17836
 * @mem 14,820kb
 * @time 156ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '공주님을 구해라!'
public class BOJ17836 {
	static int N,M,limit;
	static int [][] arr;
	static int [][][] dp;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dp = new int[N][M][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = bfs();
		
		System.out.println(answer == -1 ? "Fail" : answer);
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
	
	public static int bfs() {
		Queue<Point> q = new LinkedList<>(); 
		if(arr[0][0] == 2) {
			q.offer(new Point(0,0,true,0));
			dp[0][0][1] = 0;
		}else {
			q.offer(new Point(0,0,false,0));
			dp[0][0][0] = 0;
		}
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.route > limit) {
				return -1;
			}
			
			if(cur.x == N-1 && cur.y == M-1) {
				return cur.route;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(isIn(nx,ny)) {
					if(cur.isUltimate) {
						if(dp[nx][ny][1] > cur.route + 1) {
							dp[nx][ny][1] = cur.route + 1;
							q.offer(new Point(nx,ny,true,cur.route+1));
						}
					}else {
						if(arr[nx][ny] == 2) {
							if(dp[nx][ny][1] > cur.route + 1) {
								dp[nx][ny][1] = cur.route + 1;
								q.offer(new Point(nx,ny,true,cur.route+1));
							}
						}else {
							if(arr[nx][ny] != 1 && dp[nx][ny][0] > cur.route + 1) {
								dp[nx][ny][0] = cur.route + 1;
								q.offer(new Point(nx,ny,false,cur.route+1));
							}
						}
					}
				}
			}
		}
		return -1;
	}
	
	static class Point{
		int x;
		int y;
		boolean isUltimate;
		int route;
		public Point(int x, int y, boolean isUltimate, int route) {
			super();
			this.x = x;
			this.y = y;
			this.isUltimate = isUltimate;
			this.route = route;
		}
	}
}