/**
 * @author nakhoon
 * @date Dec 24, 2021
 * @see https://www.acmicpc.net/problem/1793
 * @mem 12,884kb
 * @time 116ms
 * @caution
 * [고려사항]
 * 입력 규칙이 평소와 달라서 어려웠던 문제이다. while문 안에 입력을 받으면서 변수값에 대입하는 방법으로 해결했다.
 * 그리고 long으로 표현할 수 없는 더 큰 수를 표현해야했기 때문에 BigInteger 객체를 통해 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.math.BigInteger;
//백준 <DP> '타일링'
public class BOJ1793 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger [] dp = new BigInteger[251];
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		
		for(int i=3;i<251;i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
		}
		String input = null;
		while((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			System.out.println(dp[n]);
		}
	}
}