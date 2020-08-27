/**
 * @author choi
 * @date Aug 27, 2020
 * @see https://www.acmicpc.net/problem/3109
 * @mem 53,268kb
 * @time 336ms
 * @caution
 * [고려사항]
 * 	flag를 static으로 선언하여 정답에 도달했을 경우에는 해당 dfs를 return 시켜주고
 * 	answer++를 하면 됐었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <백트래킹> '빵집'
public class BOJ3109_3{
	static int N,M,answer;
	static char [][] map;
	static boolean [][] visited;
	static int [] dx = {-1,0,1};
	static int [] dy = {1,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			dfs(i,0);
		}
		
		System.out.println(answer);
	}
	public static boolean dfs(int x, int y) {
		if(y == M-1) {
			answer++;
			return true;
		}
		for(int i=0;i<3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isIn(nx,ny) || visited[nx][ny] || map[nx][ny] == 'x') continue;
			visited[nx][ny] = true;
			if(dfs(nx,ny)) return true;
			//파이프 놓았던 흔적을 되돌릴 필요가 없다.(이 곳을 방문하면 어차피 파이프를 완성할 수 없으므로 true로 냅둔다.)
			//가지치기 효과
			//visited[nx][ny] = false; 
		}
		return false;
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
}