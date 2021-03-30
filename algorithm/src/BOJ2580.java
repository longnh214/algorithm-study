/**
 * @author choi
 * @date Nov 4, 2020
 * @see https://www.acmicpc.net/problem/2580
 * @mem 15,116kb
 * @time 272ms
 * @caution
 * [고려사항]
 * 백준 2239번 스도쿠와 똑같은 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <백트래킹> '스도쿠'
public class BOJ2580 {
	static int [][] map;
	static int [] temp;
	static int N,M,count;
	static boolean [][][] visited;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 9;
		M = 9;
		map = new int[N][M];
		visited = new boolean[3][9][10];
		//0 가로 1 세로 2 블록
		StringTokenizer st = null;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					count++;
					continue;
				}
				visited[0][i][map[i][j]] = true;
				visited[1][j][map[i][j]] = true;
				visited[2][(i/3)*3 + j/3][map[i][j]] = true;
			}
		}
		
		temp = new int[count];
		
		perm(0);
	}
	
	public static void perm(int cnt) {
		if(flag) return;
		if(cnt == 81) {
			flag = true;
			for(int i=0;i<9;i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<9;j++) {
					sb.append(map[i][j]).append(" ");
				}
				String str = sb.substring(0, sb.length()-1).toString();
				System.out.println(str);
			}
			return;
		}
		
		//cnt에 대한 x,y 좌표 계산
		int x = cnt / 9;
		int y = cnt % 9;
		
		if(map[x][y] != 0) {
			perm(cnt+1);
		}else {
			for(int k=1;k<=9;k++) {
				if(!visited[0][x][k] && !visited[1][y][k] && !visited[2][(x/3)*3 + y/3][k]) {
					visited[0][x][k] = true;
					visited[1][y][k] = true;
					visited[2][(x/3)*3 + y/3][k] = true;
					map[x][y] = k;
					perm(cnt+1);
					map[x][y] = 0;
					visited[0][x][k] = false;
					visited[1][y][k] = false;
					visited[2][(x/3)*3 + y/3][k] = false;
				}
			}
		}
	}
}