/**
 * @author nakhoonchoi
 * @date 2024/09/04
 * @see https://www.acmicpc.net/problem/32202
 * @mem 19,272kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 점화식을 이용해서 문제를 해결하였다.
 * 각 줄 별로, 한 명만 선택하는 경우 -> 2,
 * 두 명 전부 선택하는 방법 -> 1가 있고,
 * 두 줄 연속으로 모든 사람이 알고 있어야
 * 다른 사람들도 전부 다 알고 있음을 가지고 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DP> '풀이 전달'

public class BOJ32202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        final int MOD = 1000000007;

        if (N == 1) {
            System.out.println(3);
            return;
        }

        long[] dp = new long[N + 1];

        // 초기값 설정
        dp[0] = 1;
        dp[1] = 3; //첫 번째 줄은 (A), (B), (A, B) 와 같이 세 경우의 수가 있다.

        // DP 점화식으로 계산
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] * 2 + dp[i-2] * 2) % MOD;
        }

        // 최종 결과 출력
        System.out.println(dp[N]);
    }
}