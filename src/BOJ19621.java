/**
 * @author choi
 * @date Aug 31, 2020
 * @see https://www.acmicpc.net/problem/19621
 * @mem 13,332kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 그리디하게 풀려고 했는데, 문제에서 K-1과 회의 K+1만 회의 K와 겹친다고 했으므로
 * dp를 이용해서 풀면 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '회의실 배정 2'
public class BOJ19621 {
    static int N, answer;
    static List<Conference> list;
    static boolean [] visited;
    static int [] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dp = new int[N];
        answer = Integer.MIN_VALUE;
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            //dp[i] = people;

            list.add(new Conference(start, end, people));
        }

        if(N == 1) {
            System.out.println(list.get(0).people);
            return;
        }

        dp[0] = list.get(0).people;
        answer = Math.max(answer, dp[0]);
        dp[1] = list.get(1).people;
        answer = Math.max(answer, dp[1]);

        for(int i=2;i<N;i++) {
            for(int j=0;j<i-1;j++) {
                dp[i] = Math.max(dp[i], dp[j] + list.get(i).people);
            }
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
