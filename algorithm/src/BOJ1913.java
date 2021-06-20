/**
 * @author nakhoon
 * @date Jun 20, 2021
 * @see https://www.acmicpc.net/problem/1913
 * @mem 83,628kb
 * @time 416ms
 * @caution
 * [고려사항]
 * 배열 돌리기와 비슷한 문제이다. 다르게 풀어봤다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '달팽이'
public class BOJ1913 {
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,-1,0,1};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int [][] arr = new int[N][N];
		for(int i=0;i<arr.length;i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		int num = N*N;
		int i=0;
		int j=0;
		int dir = 0;
		int answerX = -1;
		int answerY = -1;
		if(num == target) {
			answerX = i+1;
			answerY = j+1;
		}
		arr[i][j] = num--;
		while(true) {
			i += dx[dir];
			j += dy[dir];
			if(i == N/2 && j == N/2) {
				if(num == target) {
					answerX = i+1;
					answerY = j+1;
				}
				arr[i][j] = num;
				break;
			}
			else if(!isIn(i,j) || arr[i][j] <= N*N) {
				i -= dx[dir];
				j -= dy[dir];
				dir = (dir+1)%4;
			}else {
				if(num == target) {
					answerX = i+1;
					answerY = j+1;
				}
				arr[i][j] = num--;
			}
		}
		for(i=0;i<N;i++) {
			StringBuilder sb = new StringBuilder();
			for(j=0;j<N;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			System.out.println(sb.toString().substring(0,sb.length()-1));
		}
		System.out.println(answerX + " " + answerY);
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}