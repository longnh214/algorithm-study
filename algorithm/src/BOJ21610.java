/**
 * @author nakhoon
 * @date Jun 12, 2021
 * @see https://www.acmicpc.net/problem/21610
 * @mem 26,368kb
 * @time 184ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '마법사 상어와 비바라기'
public class BOJ21610 {
	static int N,M;
	static int [][] map;
	static boolean [][] check;
	static int [] dx = {0,-1,-1,-1,0,1,1,1};
	static int [] dy = {-1,-1,0,1,1,1,0,-1};
	static int [] dx1 = {-1,1,1,-1};
	static int [] dy1 = {-1,-1,1,1};
	static List<Point> cloud;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		//check = new boolean[N][N];
		cloud = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//첫 비구름
		cloud.add(new Point(N-1,0));
		cloud.add(new Point(N-1,1));
		cloud.add(new Point(N-2,0));
		cloud.add(new Point(N-2,1));
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			
			callRain(dir,move);
		}
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	
	public static void callRain(int dir, int move) {
		List<Point> nextCloud = new ArrayList<>();
		check = new boolean[N][N];
		for(Point cur : cloud) {
			int nextX = cur.x + dx[dir-1] * move;
			int nextY = cur.y + dy[dir-1] * move;
			
			if(nextX < 0) {
				while(nextX < 0) {
					nextX += N;
				}
			}else {
				nextX %= N;
			}
			
			if(nextY < 0) {
				while(nextY < 0) {
					nextY += N;
				}
			}else {
				nextY %= N;
			}
			check[nextX][nextY] = true;
			nextCloud.add(new Point(nextX, nextY));
			map[nextX][nextY]++;
		}
		
		for(Point cur : nextCloud) {
			int count = 0;
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx1[i];
				int ny = cur.y + dy1[i];
				
				if(isIn(nx,ny) && map[nx][ny] > 0) {
					count++;
				}
			}
			map[cur.x][cur.y]+=count;
		}
		
		cloud = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j] && map[i][j] >= 2) {
					map[i][j] -= 2;
					cloud.add(new Point(i,j));
				}
			}
		}
	}
	
	
	public static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
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