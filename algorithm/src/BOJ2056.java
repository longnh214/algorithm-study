/**
 * @author nakhoon
 * @date Dec 30, 2021
 * @see https://www.acmicpc.net/problem/2056
 * @mem 60,216kb
 * @time 440ms
 * @caution
 * [고려사항]
 * 맨 처음에 문제를 봤을 때 K번 작업보다 먼저 수행되는 작업이 K보다 높은 번호의 작업일까봐 어렵다고 생각했던 문제이다.
 * "K번 작업을 시작하기 전에 반드시 먼저 완료되어야 하는 작업들의 번호는 모두 1 이상 (K-1) 이하이다."
 * 와 같은 조건이 있어서 어려움을 해소할 수 있었다.
 * K번째 작업을 입력 받기 전에 dp 배열에 각 작업의 끝나는 시간을 정리해둔 뒤에 점화식을 통해 각 선행 작업이 끝난
 * 최대값으로 설정하면 되었다.(최대값으로 갱신해주는 이유는 모든 작업이 끝난 뒤의 시간이여야 하기 때문이다.)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '작업'
public class BOJ2056 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] dp = new int[N+1];
		int answer = 0;
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			dp[i] = time;
			for(int j=0;j<count;j++) {
				int work = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(dp[i], dp[work] + time);
			}
			
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}
}