/**
 * @author nakhoon
 * @date Jul 20, 2021
 * @see https://www.acmicpc.net/problem/5557
 * @mem 11,572kb
 * @time 88ms
 * @caution
 * [고려사항]
 * +나 - 결과값을 인덱스로 해서 dp에 해당 값에 도달한 횟수를 저장하고, 마지막 숫자와 같은 dp 값을 출력하면 된다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '1학년'
public class BOJ5557 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		long [][] dp = new long[N][21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][arr[0]] = 1;
		
		for(int i=2;i<N;i++) {
			for(int j=0;j<21;j++) {
				if(dp[i-1][j] != 0) {
					if(j + arr[i-1] <= 20 && j + arr[i-1] >= 0) {
						dp[i][j+arr[i-1]] += dp[i-1][j];
					}
					if(j - arr[i-1] <= 20 && j - arr[i-1] >= 0) {
						dp[i][j-arr[i-1]] += dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[N-1][arr[N-1]]);
		br.close();
	}
}