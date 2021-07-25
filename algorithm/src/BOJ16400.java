/**
 * @author nakhoon
 * @date Jul 25, 2021
 * @see https://www.acmicpc.net/problem/16400
 * @mem 13,336kb
 * @time 324ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '소수 화폐'
public class BOJ16400 {
	static final int MOD = 123456789;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> primeList = new ArrayList<>();
		
		//true : 소수 아니다. false : 소수이다.
		boolean [] isPrime = new boolean[40001];
		
		isPrime[0] = true;
		isPrime[1] = true;
		
		for(int i=2;i<=200;i++) {
			for(int j=2;j*i<40001;j++) {
				isPrime[j*i] = true;
			}
		}
		
		for(int i=2;i<=N;i++) {
			if(!isPrime[i])
				primeList.add(i);
		}
		
		int [] dp = new int[N+1];
		dp[0] = 1;
		for(int prime : primeList) {
			for(int i=prime;i<=N;i++) {
				dp[i] = (dp[i] + dp[i-prime]) % MOD;
			}
		}	
		System.out.println(dp[N]);
	}
}