/**
 * @author nakhoon
 * @date Jun 6, 2021
 * @see https://www.acmicpc.net/problem/21608
 * @mem 17,568kb
 * @time 180ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '상어 초등학교'
public class BOJ21608 {
	static int N, answer;
	static int [][] map, check;
	static int [][] stdArr;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		stdArr = new int[N*N+1][4];
		for(int i=0;i<N*N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int student = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<4;j++) {
				stdArr[student][j] = Integer.parseInt(st.nextToken());
			}
			
			check = new int[N][N];
			int max = Integer.MIN_VALUE;
			int indexX = 0;
			int indexY = 0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(map[j][k] != 0)
						continue;
					
					
					for(int m=0;m<4;m++) {
						int nj = j + dx[m];
						int nk = k + dy[m];
						
						if(isIn(nj,nk) && map[nj][nk] == 0) {
							check[j][k]++;
						}else if(isIn(nj,nk) && isLike(student,map[nj][nk])) {
							check[j][k]+=10;
						}
					}
					
					if(max < check[j][k]) {
						indexX = j;
						indexY = k;
						max = check[j][k];
					}
				}
			}
			
			map[indexX][indexY] = student;
		}
		answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int student = map[i][j];
				
				int cnt = 0;
				
				for(int k=0;k<4;k++) {
					int ni = i + dx[k];
					int nj = j + dy[k];
					
					if(isIn(ni,nj) && isLike(student,map[ni][nj])) {
						cnt++;
					}
				}
				
				switch(cnt) {
				case 1:
					answer++;
					break;
				case 2:
					answer+=10;
					break;
				case 3:
					answer+=100;
					break;
				case 4:
					answer+=1000;
					break;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static boolean isLike(int student, int like) {
		for(int i=0;i<4;i++) {
			if(stdArr[student][i] == like)
				return true;
		}
		return false;
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}