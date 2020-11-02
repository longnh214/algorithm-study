/**
 * @author choi
 * @date Nov 2, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq
 * @mem 19,452kb
 * @time 103ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D4> '수영장'
public class Solution1952 {
    static int [] prices;
    static int [] plan, dp;
    static int answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int t=1;t<=T;t++) {
            prices = new int[4];
            plan = new int[13];
            dp = new int[13];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=12;i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= 12; i++) {
                //1일 이용권 vs 1달 이용권
                dp[i] = Math.min(plan[i] * prices[0], prices[1]) + dp[i - 1];
                if (i >= 3) {
                    //3달 이용권 비용 dp 비교
                    dp[i] = Math.min(dp[i], prices[2] + dp[i - 3]);
                }
            }
            answer = Math.min(dp[12], prices[3]); // 최소비용 vs 1년권 비용
            System.out.println("#"+ t + " " + answer);
        }
    }
}