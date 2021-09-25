/**
 * @author nakhoon
 * @date Sep 25, 2021
 * @see https://www.acmicpc.net/problem/11726
 * @mem 11,496kb
 * @time 80ms
 * @caution
 * [고려사항]
 * dp 배열을 선언할 때 N+1로 선언하면, N에 1이 들어왔을 때 반복문 중 i=3에 접근을 하지 못하여(ArrayIndexBoundException)이 나타나 런타임 에러가 난다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '2×n 타일링'
public class BOJ11726 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] dp = new int[N+3];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=N;i++) {
			dp[i] = (dp[i-2] + dp[i-1])%10007;
		}
		System.out.println(dp[N]);
	}
}