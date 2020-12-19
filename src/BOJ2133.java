/**
 * @author choi
 * @date Dec 19, 2020
 * @see https://www.acmicpc.net/problem/2133
 * @mem 11,484kb
 * @time 84ms
 * @caution
 * [고려사항]
 * N이 짝수일 때 발생할 수 있는 특수 케이스 2가지를 고려해야하는 생각하기 어려운 문제였다.
 * 	(--)(--)(--)
 * 	 |(--)(--)|
 *   |(--)(--)|
 *  의 경우...
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '타일 채우기'
public class BOJ2133 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];

        if(N>1 && N%2== 0) {
            dp[0] = 1;
            dp[2] = 3;
            for(int i=4;i<=N;i+=2) {
                dp[i] = 3 * dp[i-2]; //dp[2] * dp[i-2]
                for(int j=4;j<=i;j+=2)
                    dp[i] += 2 * dp[i-j]; //특수 경우(짝수 변형 케이스) * dp[i-짝수]
            }
        }
        System.out.println(dp[N]);
    }
}