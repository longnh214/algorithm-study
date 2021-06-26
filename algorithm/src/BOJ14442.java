/**
 * @author nakhoon
 * @date Jun 26, 2021
 * @see https://www.acmicpc.net/problem/14442
 * @mem 401,340kb
 * @time 1,344ms
 * @caution
 * [고려사항]
 * 벽 부수고 이동하기 1과 비슷한 문제지만 벽 상황에 따른 dp 배열을 생성해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '벽 부수고 이동하기 2'
public class BOJ14442 {
	static int N,M,K;
	static int [][] arr;
	static int [][][] visited;
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new int[N][M][K+1];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0,K,1));
		visited[0][0][K] = 0;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.x == N-1 && cur.y == M-1) {
				return cur.route;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nCount = cur.count;
				if(!isIn(nx,ny))
					continue;
				if(arr[nx][ny] == 1)
					nCount--;
				if(nCount < 0)
					continue;
				if(visited[nx][ny][nCount] <= cur.route+1)
					continue;
				
				visited[nx][ny][nCount] = cur.route+1;
				q.offer(new Point(nx,ny,nCount,cur.route+1));
			}
		}
		
		return -1;
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
	
	static class Point{
		int x;
		int y;
		int count;
		int route;
		Point(int x, int y, int count, int route){
			this.x = x;
			this.y = y;
			this.count = count;
			this.route = route;
		}
	}
}