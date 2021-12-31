/**
 * @author nakhoon
 * @date Dec 31, 2021
 * @see https://www.acmicpc.net/problem/7579
 * @mem 11,924kb
 * @time 104ms
 * @caution
 * [고려사항]
 * dp배열의 인덱스를 cache 값, 배열 값을 메모리 값으로 해서 dp의 값이 M을 넘는 가장 최소 인덱스를 출력하면 되는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '앱'
public class BOJ7579 {
	static int N,M;
	static int [] memory;
	static int [] cache;
	static int [] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		memory = new int[N];
		cache = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cache[i] = Integer.parseInt(st.nextToken());
			size += cache[i];
		}
		
		dp = new int[size+1]; //dp의 인덱스는 바이트 값은 메모리
		
		for(int i=0;i<N;i++) {
			for(int j=size;j>=cache[i];j--) {
				dp[j] = Math.max(dp[j], dp[j - cache[i]] + memory[i]);
			}
		}
		
		int answer = -1;
		for(int i=0;i<=size;i++) {
			if(dp[i] >=M) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}