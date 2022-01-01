/**
 * @author nakhoon
 * @date Jan 1, 2022
 * @see https://www.acmicpc.net/problem/2096
 * @mem 53,036kb
 * @time 404ms
 * @caution
 * [고려사항]
 * dp 배열을 이용해서 점화식을 이용했다. 최소값을 저장하는 dp 배열과 최대값을 저장하는 dp 배열을 따로 지정했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '내려가기'
public class BOJ2096 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [][] minDp = new int[N][3];
		int [][] maxDp = new int[N][3];
		int [][] arr = new int[N][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++) {
			minDp[0][i] = maxDp[0][i] = arr[0][i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(minDp[i], Integer.MAX_VALUE);
			for(int j=0;j<3;j++) {
				if(isIn(j-1)) {
					maxDp[i][j] = Math.max(Integer.MIN_VALUE, maxDp[i-1][j-1] + arr[i][j]);
					minDp[i][j] = Math.min(minDp[i][j], minDp[i-1][j-1] + arr[i][j]);
				}
				maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i-1][j] + arr[i][j]);
				minDp[i][j] = Math.min(minDp[i][j], minDp[i-1][j] + arr[i][j]);
				if(isIn(j+1)) {
					maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i-1][j+1] + arr[i][j]);
					minDp[i][j] = Math.min(minDp[i][j], minDp[i-1][j+1] + arr[i][j]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min = Math.min(min, minDp[N-1][i]);
			max = Math.max(max, maxDp[N-1][i]);
		}
		System.out.println(max + " " + min);
	}
	
	public static boolean isIn(int index) {
		return index >= 0 && index < 3;
	}
}