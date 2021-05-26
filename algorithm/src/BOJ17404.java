/**
 * @author nakhoon
 * @date May 26, 2021
 * @see https://www.acmicpc.net/problem/17404
 * @mem 12,024kb
 * @time 96ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> 'RGB거리2'
public class BOJ17404 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] dp = new int[N+1][3];
		int [][] arr = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = Integer.MAX_VALUE;
		int max = 1000 * (N+1);
		for(int k=0;k<3;k++) {
			//첫번째 집의 색을 정해놓고 그 외의 색은 max로 dp값 삽입
			for(int i=0;i<3;i++) {
				if(i==k) dp[1][i] = arr[1][i];
				else dp[1][i] = max;
			}
			for(int i=2;i<=N;i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
			//마지막 N의 값은 k와 같으면 안된다.
			for(int i=0;i<3;i++) {
				if(i==k) continue;
				answer = Math.min(answer, dp[N][i]);
			}
		}
		System.out.println(answer);
	}
}