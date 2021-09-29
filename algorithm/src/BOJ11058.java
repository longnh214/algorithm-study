/**
 * @author nakhoon
 * @date Sep 30, 2021
 * @see https://www.acmicpc.net/problem/11058
 * @mem 11,512kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 점화식을 스스로 세워서 푼 DP 문제 중 하나이다.
 * 
 * 문제에 나와있는 N이 3일 때, 7일 때의 차이를 보고 힌트를 얻었다.
 * 
 * 일단, N이 1부터 6일 때 까지는 버퍼를 이용하지 않고 A를 적는 버튼만 누르는 방법이 최대값을 얻을 수 있는 방법이다.
 * 하지만 예제에 나와있듯이 7부터는 다르다.
 * 
 * 그 전에 다른 버튼들의 조합도 생각을 해야하는데, (전체 선택 + 복사 + 붙여넣기) 3단계는 전체 선택한 값 값의 두 배로 출력하게 된다.
 * 그리고 붙여넣기를 여러번 하는 경우의 수도 있다. (전체 선택 + 복사 + 붙여넣기 + 붙여넣기) 4단계는 전체 선택한 값의 세 배로 출력하게 되고,
 * (전체 선택 + 복사 + 붙여넣기 + 붙여넣기) 5단계는 전체 선택한 값의 네 배로 출력하게 된다. 
 * 
 * 그래서 7이 넘어간 이후부터는 3단계를 진행한 값, 4단계를 진행한 값, 5단계를 진행한 값 중 최대값을 dp 배열에 넣어주었다.
 * 
 * (Solved!)
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '크리보드'
public class BOJ11058 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long [] dp = new long[N+1];
		
		if(N <= 6) {
			System.out.println(N);
			return;
		}
		
		for(int i=1;i<=6;i++) {
			dp[i] = i;
		}
		
		for(int i=7;i<=N;i++) {
			dp[i] = Math.max(dp[i-3] * 2, Math.max(dp[i-4] * 3, dp[i-5] * 4));
		}
		
		System.out.println(dp[N]);
	}
}