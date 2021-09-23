/**
 * @author nakhoon
 * @date Sep 23, 2021
 * @see https://www.acmicpc.net/problem/1912
 * @mem 22,160kb
 * @time 204ms
 * @caution
 * [고려사항]
 * O(N^2)로 풀었더니 시간 초과가 나서 O(N)으로 풀 수 있도록 개선하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '연속합'
public class BOJ1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		int [] dp = new int[N];
		int answer = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = answer = arr[0];
		for(int i=1;i<N;i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}