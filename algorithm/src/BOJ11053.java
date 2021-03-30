/**
 * @author choi
 * @date Sep 1, 2020
 * @see https://www.acmicpc.net/problem/11053
 * @mem 13,424kb
 * @time 104ms
 * @caution
 * [고려사항]
 * 6
 * 1 2 1 4 3 4
 * 의 테스트케이스와 같이 중간에 낮아졌다 올라가는 부분에 대해 고려를 안해줬었다.
 * for(int i=1;i<N;i++) {
 * 		for(int j=0;j<i;j++) {
 *	와 같이 기준 인덱스 전을 전부 탐색해서 각 인덱스 기준마다의 최장 배열을 저장해야했다.
 *	기존의 dp 값을 갱신하는 방법은 올바른 방법이 아니였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '가장 긴 증가하는 부분 수열'
public class BOJ11053 {
    static int [] num;
    static int [] dp;
    static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for(int i=1;i<N;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(num[j] < num[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for(int num : dp) {
            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}