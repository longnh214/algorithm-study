/**
 * @author nakhoon
 * @date 2022/07/26
 * @see https://www.acmicpc.net/problem/13699
 * @mem 11,492kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 점화식을 세워서 문제를 해결할 수 있었다.
 * long 형으로 dp 배열을 선언해야 했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '점화식'
public class BOJ13699 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long [] dp = new long[N+1];
    dp[0] = 1L;
    for(int i=1;i<=N;i++){
      for(int j=0;j<i;j++){
        dp[i] += (dp[j] * dp[i-j-1]);
      }
    }
    System.out.println(dp[N]);
  }
}