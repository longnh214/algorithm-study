/**
 * @author nakhoon
 * @date Feb 13, 2022
 * @see https://www.acmicpc.net/problem/16935
 * @mem 103,020kb
 * @time 488ms
 * @caution
 * [고려사항]
 * 배열 돌리기 문제가 특정 기업에서 나오기 때문에 문제를 연습할 겸 풀어보았다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '배열 돌리기 3'
public class BOJ16935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int [][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int oper = Integer.parseInt(st.nextToken());
			int [][] arr2;
			switch(oper) {
			case 1:
				arr2 = new int[arr.length][arr[0].length];
				for(int j=0;j<arr.length;j++) {
					for(int k=0;k<arr[0].length;k++) {
						arr2[j][k] = arr[arr.length - j - 1][k];
					}
				}
				arr = arr2;
				break;
			case 2:
				arr2 = new int[arr.length][arr[0].length];
				for(int j=0;j<arr.length;j++) {
					for(int k=0;k<arr[0].length;k++) {
						arr2[j][k] = arr[j][arr[0].length - k - 1];
					}
				}
				arr = arr2;
				break;
			case 3:
				arr2 = new int[arr[0].length][arr.length];
				for(int j=0;j<arr.length;j++) {
					for(int k=0;k<arr[0].length;k++) {
						arr2[k][arr.length - j - 1] = arr[j][k];
					}
				}
				arr = arr2;
				break;
			case 4:
				arr2 = new int[arr[0].length][arr.length];
				for(int j=0;j<arr.length;j++) {
					for(int k=0;k<arr[0].length;k++) {
						arr2[arr[0].length - k - 1][j] = arr[j][k];
					}
				}
				arr = arr2;
				break;
			case 5:
				arr2 = new int[arr.length][arr[0].length];
				for(int j=0;j<arr.length/2;j++) {
					for(int k=0;k<arr[0].length/2;k++) {
						arr2[j][arr[0].length/2 + k] = arr[j][k];
					}
				}
				for(int j=0;j<arr.length/2;j++) {
					for(int k=0;k<arr[0].length/2;k++) {
						arr2[arr.length/2 + j][arr[0].length/2 + k] = arr[j][arr[0].length/2 + k];
					}
				}
				for(int j=0;j<arr.length/2;j++) {
					for(int k=0;k<arr[0].length/2;k++) {
						arr2[arr.length/2 + j][k]  = arr[arr.length/2 + j][arr[0].length/2 + k];
					}
				}
				for(int j=0;j<arr.length/2;j++) {
					for(int k=0;k<arr[0].length/2;k++) {
						arr2[j][k] = arr[arr.length/2 + j][k];
					}
				}
				arr = arr2;
				break;
			case 6:
				arr2 = new int[arr.length][arr[0].length];
				for(int j=0;j<arr.length/2;j++) {
					for(int k=0;k<arr[0].length/2;k++) {
						arr2[arr.length/2 + j][k] = arr[j][k];
					}
				}
				for(int j=0;j<arr.length/2;j++) {
					for(int k=0;k<arr[0].length/2;k++) {
						arr2[j][k] = arr[j][arr[0].length/2 + k];
					}
				}
				for(int j=0;j<arr.length/2;j++) {
					for(int k=0;k<arr[0].length/2;k++) {
						arr2[j][arr[0].length/2 + k]  = arr[arr.length/2 + j][arr[0].length/2 + k];
					}
				}
				for(int j=0;j<arr.length/2;j++) {
					for(int k=0;k<arr[0].length/2;k++) {
						arr2[arr.length/2 + j][arr[0].length/2 + k] = arr[arr.length/2 + j][k];
					}
				}
				arr = arr2;
				break;
			}
		}
		print(arr);
	}
	public static void print(int [][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb = new StringBuilder(sb.substring(0,sb.length()-1));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}