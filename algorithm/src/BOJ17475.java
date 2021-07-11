/**
 * @author nakhoon
 * @date Jul 11, 2021
 * @see https://www.acmicpc.net/problem/17425
 * @mem 62,472kb
 * @time 468ms
 * @caution
 * [고려사항]
 * 약수의 합으로 생각하면 시간 초과가 나고, 배수를 통해 미리 값을 더해주고( f(x) ),
 * dp 식으로 해서 값을 더해주면 답이 나온다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '약수의 합'
public class BOJ17475 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		long [] measure = new long[1000001]; // f(x)
		long [] dp = new long[1000001]; // g(x)
		
		Arrays.fill(measure, 1);
		
		for(int i=2;i<measure.length;i++) {
			for(int j=1;i*j<measure.length;j++) {
				measure[i*j] += i;
			}
		}
		
		for(int i=1;i<dp.length;i++) {
			dp[i] += (dp[i-1] + measure[i]);
		}
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}