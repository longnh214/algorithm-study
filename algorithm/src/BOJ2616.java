/**
 * @author nakhoon
 * @date Jul 19, 2021
 * @see https://www.acmicpc.net/problem/2616
 * @mem 19,792kb
 * @time 172ms
 * @caution
 * [고려사항]
 * 슬라이딩 윈도우를 통하여 누적 합을 저장하고, dp를 이용해서 소형기관차 대 수에 대한 최댓값을 저장해두었다.
 * dp 문제는 배열 인덱스를 0부터가 아닌 1로 시작하는 습관을 들여야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '소형기관차'
public class BOJ2616 {
	static int [] grpSum;
	static int [] arr;
	static int N, grp;
	static int [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		grpSum = new int[N+1];
		dp = new int[N+1][4];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		grp = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = grp;
		int sum = 0;
		for(int i=start;i<=end;i++) {
			sum += arr[i];
		}
		grpSum[end] = sum;
		end++;
		for(;end<=N;end++) {
			sum -= arr[start++];
			sum += arr[end];
			grpSum[end] = sum;
		}
		
		for(int i=1;i<=3;i++) {
			for(int j=i*grp;j<=N;j++) {
				dp[j][i] = Math.max(dp[j-1][i], dp[j-grp][i-1] + grpSum[j]);
			}
		}
		
		System.out.println(dp[N][3]);
	}
}