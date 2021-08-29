/**
 * @author nakhoon
 * @date Aug 29, 2021
 * @see https://www.acmicpc.net/problem/14923
 * @mem 184,252kb
 * @time 1,096ms
 * @caution
 * [고려사항]
 * 이전에 풀어봤던 벽 부수고 이동하기와 똑같은 문제였다. dp에 bfs를 접목시켜 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '미로 탈출'
public class BOJ14923 {	
	static int [][][] dp;
	static int [][] map;
	static int N,M;
	static int startX, startY, endX, endY;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M][2];
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken()) - 1;
		startY = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine());
		endX = Integer.parseInt(st.nextToken()) - 1;
		endY = Integer.parseInt(st.nextToken()) - 1;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j][0] = dp[i][j][1] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		int answer = Math.min(dp[endX][endY][0], dp[endX][endY][1]);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer );
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		dp[startX][startY][0] = 0;
		q.offer(new Point(startX, startY, false));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(!isIn(nx,ny)) continue;
				
				if(cur.isUseMagic) {
					if(map[nx][ny] == 1) {
						continue;
					}else {
						if(dp[cur.x][cur.y][1] + 1 < dp[nx][ny][1]) {
							dp[nx][ny][1] = dp[cur.x][cur.y][1] + 1;
							q.offer(new Point(nx,ny,true));
						}
					}
				}else {
					if(map[nx][ny] == 1) {
						if(dp[cur.x][cur.y][0] + 1 < dp[nx][ny][1]) {
							dp[nx][ny][1] = dp[cur.x][cur.y][0] + 1;
							q.offer(new Point(nx,ny,true));
						}
					}else {
						if(dp[cur.x][cur.y][0] + 1 < dp[nx][ny][0]) {
							dp[nx][ny][0] = dp[cur.x][cur.y][0] + 1;
							q.offer(new Point(nx,ny,false));
						}
					}
				}
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

	static class Point{
		int x;
		int y;
		boolean isUseMagic;
		Point(int x, int y, boolean isUseMagic){
			this.x = x;
			this.y = y;
			this.isUseMagic = isUseMagic;
		}
	}
}