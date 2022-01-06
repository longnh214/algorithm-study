/**
 * @author nakhoon
 * @date Jan 6, 2022
 * @see https://www.acmicpc.net/problem/3067
 * @mem 12,044kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 동전 관련 DP 문제였다. 큰 값의 동전부터 dp 배열에 경우의 수를 갱신해주어 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> 'Coins'
public class BOJ3067 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int [] coin = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			int target = Integer.parseInt(br.readLine());
			int [] dp = new int[target+1];
			for(int i=coin.length-1;i>=0;i--) {
				int curCoin = coin[i];
				dp[curCoin]++;
				for(int j=curCoin;j<=target;j++) {
					dp[j] = dp[j] + dp[j - curCoin];
				}
			}
			System.out.println(dp[target]);
		}
	}
}