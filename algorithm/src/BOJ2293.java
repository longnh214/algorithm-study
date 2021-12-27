/**
 * @author nakhoon
 * @date Dec 27, 2021
 * @see https://www.acmicpc.net/problem/2293
 * @mem 11,756kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 점화식을 세우는 데에는 오래 걸리지 않지만 반복문을 순회하는 과정에서 이중 for문의 밖을 dp 배열의 인덱스로 하고 
 * 안쪽의 for 문을 동전의 값으 잘못 생각해서 오래 걸렸던 문제이다. 
 * dp[j] += dp[j - coin[i]] 를 동전을 입력받을 때마다 실행하면 되는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '동전 1'
public class BOJ2293 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] dp = new int[k+1];
		int [] coin = new int[n];
		dp[0] = 1;
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for(int j=coin[i];j<=k;j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		System.out.println(dp[k]);
	}
}