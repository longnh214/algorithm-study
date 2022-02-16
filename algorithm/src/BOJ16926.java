/**
 * @author nakhoon
 * @date Feb 16, 2022
 * @see https://www.acmicpc.net/problem/16926
 * @mem 303,412kb
 * @time 1,016ms
 * @caution
 * [고려사항]
 * 배열 돌리기 문제가 특정 기업에서 나오기 때문에 문제를 연습할 겸 풀어보았다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현>'배열 돌리기 1'
public class BOJ16926 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int [][] arr = new int[N][M];
		int totalRotateCount = Math.min(N, M) / 2;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<R;i++) {
			//회전
			for(int j=0;j<totalRotateCount;j++)
				rotate(arr, j);
		}
		print(arr);
	}
	
	public static void print(int [][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb = new StringBuilder(sb.substring(0, sb.length()-1));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void rotate(int [][] arr, int rotateCount) {
		int temp = arr[rotateCount][rotateCount];
		for(int i=rotateCount;i<arr[0].length - rotateCount - 1;i++) {
			arr[rotateCount][i] = arr[rotateCount][i+1];
		}
		for(int i=rotateCount;i<arr.length - rotateCount - 1;i++) {
			arr[i][arr[0].length - rotateCount - 1] = arr[i+1][arr[0].length - rotateCount - 1];
		}
		for(int i=arr[0].length - rotateCount - 2;i>=rotateCount;i--) {
			arr[arr.length - rotateCount - 1][i+1] = arr[arr.length - rotateCount - 1][i];
		}
		for(int i=arr.length - rotateCount - 2;i>=rotateCount;i--) {
			arr[i+1][rotateCount] = arr[i][rotateCount];
		}
		arr[rotateCount+1][rotateCount] = temp;
	}
}