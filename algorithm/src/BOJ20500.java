/**
 * @author nakhoon
 * @date Sep 29, 2021
 * @see https://www.acmicpc.net/problem/20500
 * @mem 11,456kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 문제 제목이 너무 재미있어서 풀었던 문제인데... DP 점화식 세우기는 너무 어렵다.
 * 15의 배수는 3의 배수이면서 5의 배수이면 된다. 5의 배수이려면 1의 자리가 0이거나 5여야 하는데, 1과 5밖에 사용할 수 없으므로 끝자리는 5로 고정.
 * dp 배열을 (dp[3으로 나눈 나머지][자리수])로 생각하고 초기값을 지정할 때, 2자리 수 중 일의 자리는 5로 고정이기에 (15,55) 밖에 올 수 없다.
 * 15는 3으로 나누면 나머지 0, 55는 3으로 나누면 나머지 1이므로 dp[0][2] = 1, dp[1][2] = 1로 초기값을 둔다.
 * 
 * 점화식은 예를 들어 15(나머지 0인 두 자리 수)의 앞에 1과 5를 붙이면 115, 515가 될 수 있는데, 이는 각각 나머지가 1, 2가 된다.
 * 그리고 55(나머지 1인 두 자리 수)의 앞에 1과 5를 붙이면 155,555가 될 수 있는데 이는 각각 나머지가 2,0이 된다.
 * 
 * 위를 정리해보면
 * 나머지가 0인 i자리수 = 나머지가 1인 i-1자리 수 + 나머지가 2인 i-1자리 수
 * 나머지가 1인 i자리수 = 나머지가 2인 i-1자리 수 + 나머지가 0인 i-1자리 수
 * 나머지가 2인 i자리수 = 나머지가 0인 i-1자리 수 + 나머지가 1인 i-1자리 수
 * 
 * 와 같은 점화식이 나오게 된다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> 'Ezreal 여눈부터 가네 ㅈㅈ'
public class BOJ20500 {
	static final long MOD = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		//dp[3으로 나눈 나머지][자리수]
		long [][] dp = new long[3][N+1];
		
		dp[0][2] = dp[1][2] = 1;

		for(int i=3;i<=N;i++) {
			dp[0][i] = (dp[1][i-1] + dp[2][i-1]) % MOD;
			dp[1][i] = (dp[2][i-1] + dp[0][i-1]) % MOD;
			dp[2][i] = (dp[1][i-1] + dp[0][i-1]) % MOD;
		}
		System.out.println(dp[0][N]);
	}
}