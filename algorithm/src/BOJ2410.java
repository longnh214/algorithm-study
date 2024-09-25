/**
 * @author nakhoonchoi
 * @date 2024/09/25
 * @see https://www.acmicpc.net/problem/2410
 * @mem 15,500kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 1부터 7까지 개수를 세어보니, 규칙이 하나 나왔다. n이 홀수인 경우에는 n-1의 경우의 수와 같고,
 * n이 짝수인 경우의 점화식이 어려웠는데, n-1의 경우의 수와 n/2의 경우의 수의 합이 총 경우의 수다.
 * 왜냐하면 2의 멱수로 이루어지기 때문에 n/2의 경우의 수들을
 * (3의 1+1+1, 1+2을 전부 두 배해서 2+2+2, 2+4)처럼 생각하면 6의 경우의 수로 들어갈 수 있기 때문
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '2의 멱수의 합'
public class BOJ2410 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MOD = 1_000_000_000;

        int [] dp = new int[N+1];
        dp[0] = 1;

        for(int i=1;i<=N;i++){
            if(i % 2 == 0){
                dp[i] += ((dp[i-1] + dp[i/2]) % MOD);
            }else{
                dp[i] += (dp[i-1] % MOD);
            }
        }

        System.out.println(dp[N]);
    }
}