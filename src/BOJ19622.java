/**
 * @author choi
 * @date Aug 31, 2020
 * @see https://www.acmicpc.net/problem/19622
 * @mem 46,136kb
 * @time 320ms
 * @caution
 * [고려사항]
 * 19621번 회의실 배정 2와 비슷하지만, 2중 for문을 사용하면 시간 초과가 나고,
 * 점화식을 만들어 for문 한번에 최대값을 뽑아야 정답이 되었다.
 * 배열이 총 100,000개를 딱 맞춰 선언하면 런타임 에러가 나는 경우가 있으므로
 * 배열을 넉넉하게 +2 만큼 더 선언하였더니 정답이 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '회의실 배정 3'
public class BOJ19622 {
    static int N, answer;
    static int [] conference;
    static int [] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        conference = new int[N+2];
        dp = new int[N+2];
        answer = Integer.MIN_VALUE;
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();
            conference[i] = Integer.parseInt(st.nextToken());
            //dp[i] = people;
        }

        if(N == 1) {
            System.out.println(conference[0]);
            return;
        }

        dp[0] = conference[0];
        answer = Math.max(answer, dp[0]);
        dp[1] = conference[1];
        answer = Math.max(answer, dp[1]);
        dp[2] = conference[2] + dp[0];
        answer = Math.max(answer, dp[2]);

        for(int i=3;i<N;i++) {

            dp[i] = conference[i] + Math.max(dp[i-3], dp[i-2]);

            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

    static class Conference{
        int start;
        int end;
        int people;
        public Conference(int start, int end, int people) {
            this.start = start;
            this.end = end;
            this.people = people;
        }
    }
}