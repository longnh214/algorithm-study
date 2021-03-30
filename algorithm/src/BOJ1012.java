import java.util.*;
import java.io.*;
//백준 1012번 <DFS/BFS> - '유기농 배추'
//visited 2차원 배열을 사용해야 시간 초과 안 나고 풀 수 있는 문제
//지나간 곳은 0으로 바꿔주려 했지만 시간 초과.
public class BOJ1012 {
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static int T;
	static int M,N,count;
	static int answer = 0;
	static int [][] farm;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			count = Integer.parseInt(st.nextToken());
			
			farm = new int[M][N];
			visited = new boolean[M][N];
			for(int i=0;i<count;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				farm[a][b] = 1;
			}
			
			count = 0;
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(farm[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			//farm[cur.x][cur.y] = 0;
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				else if(farm[nx][ny] == 1 && !visited[nx][ny]) {
					q.add(new Point(nx,ny));
					visited[nx][ny] = true;
				}
				else continue;
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