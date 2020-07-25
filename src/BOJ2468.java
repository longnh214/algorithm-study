import java.util.*;
import java.io.*;
//백준 2468번 <DFS/BFS> '안전 영역'
public class BOJ2468 {
	static int N;
	static int [][] map;
	static int max;
	static int count;
	static int answer;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	static boolean [][] visited;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		max = Integer.MIN_VALUE;
		answer = Integer.MIN_VALUE;
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		visited = new boolean[N][N];
		for(int k=0;k<=max;k++) {
			count = 0;
			for(boolean a[] : visited)
				Arrays.fill(a, false);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j] > k) {
						bfs(k,i,j);
						count++;
					}
				}
			}
			//System.out.println(k + ", " + count);
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}
	
	public static void bfs(int limit, int x, int y) {
		visited[x][y] = true;
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			//System.out.println(limit + ", " + x + ", " + y);
			Point cur = q.poll();
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > limit && !visited[nx][ny]) { 
					visited[nx][ny] = true;
					q.add(new Point(nx,ny));
				}
			}
		}
	}

	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}