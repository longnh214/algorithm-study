/**
 * @author choi
 * @date Nov 4, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc
 * @mem 48,440 kb
 * @time 226ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <SW역량테스트> '파핑파핑 지뢰찾기'
public class Solution1868 {
	static char [][] map;
	static int N,answer;
	static boolean [][] visited;
	static int [] dx = {-1,-1,0,1,1,1,0,-1};
	static int [] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			map = new char[N][N];
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == '.' && count(i,j) == 0) {
						bfs(i,j);
						answer++;
					}
						
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == '.') {
						answer++;
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
		
		
	}
	
	public static int count(int x, int y) {
		int count = 0;
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isIn(nx,ny) && map[nx][ny] == '*')
				count++;
		}
		
		return count;
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			map[temp.x][temp.y] = (char) (count(temp.x, temp.y) + '0');
			if(count(temp.x, temp.y) == 0) {
				for(int i=0;i<8;i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];
					
					if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] == '.') {
						visited[nx][ny] = true;
						q.offer(new Point(nx,ny));
					}
				}
			}
		}
	}
	
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
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