/**
 * @author nakhoon
 * @date Aug 22, 2021
 * @see https://www.acmicpc.net/problem/2665
 * @mem 11,768kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 메모이제이션과 bfs를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '미로만들기'
public class BOJ2665 {
	static char [][] map;
	static int N;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	static int [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		dp = new int[N][N];
		String str;
		for(int i=0;i<N;i++) {
			str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0,0,0));
		dp[0][0] = 0;		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.x == N-1 && cur.y == N-1) {
				System.out.println(cur.route);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nRoute = cur.route;
				if(isIn(nx,ny)) {
					if(map[nx][ny] == '0') {
						nRoute = cur.route + 1;
					}
					if(dp[nx][ny] > nRoute) {
						dp[nx][ny] = nRoute;
						pq.offer(new Point(nx,ny,nRoute));
					}
				}
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}

	static class Point implements Comparable<Point>{
		int x;
		int y;
		int route;
		Point(int x, int y, int route){
			this.x = x;
			this.y = y;
			this.route = route;
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.route, o.route);
		}
	}
}