/**
 * @author nakhoon
 * @date 2022/07/22
 * @see https://www.acmicpc.net/problem/17175
 * @mem 11,516kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 점화식을 만들어서 문제를 해결할 수 있었다.
 * N이 1일 때를 예외처리 하지 않아서 한 번 틀렸다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '피보나치는 지겨웡~'
public class BOJ17175 {
  static final int MOD = 1_000_000_007;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long [] dp = new long[N+1];
    if(N <= 1){
      System.out.println(1);
      return;
    }
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2;i<=N;i++){
      dp[i] = (dp[i-1] + dp[i-2] + 1) % MOD;
    }
    System.out.println(dp[N]);
  }
}