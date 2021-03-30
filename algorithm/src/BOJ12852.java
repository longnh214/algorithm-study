/**
 * @author choi
 * @date Sep 18, 2020
 * @see https://www.acmicpc.net/problem/12852
 * @mem 62,220kb
 * @time 240ms
 * @caution
 * [고려사항]
 * 메모이제이션과 bfs를 이용하여 문제를 풀었다.
 * 두 개의 배열을 만들어 경로를 저장한 후 끝까지 경로를 출력하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP/BFS> '1로 만들기 2'
public class BOJ12852 {
    static int [] dp;
    static boolean [] visited;
    static int [] from;
    static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        visited = new boolean[N+1];
        from = new int[N+1];
        sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        q.offer(N);
        visited[N] = true;
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp < 1 || temp > 1000000) continue;
            if(temp % 3 == 0) {
                if(!visited[temp/3]) {
                    q.offer(temp/3);
                    visited[temp/3] = true;
                    dp[temp/3] = dp[temp] + 1;
                    from[temp/3] = temp;
                }else if(dp[temp/3] > dp[temp] + 1) {
                    dp[temp/3] = dp[temp] + 1;
                    from[temp/3] = temp;
                }
            }
            if(temp % 2 == 0) {
                if(!visited[temp/2]) {
                    q.offer(temp/2);
                    visited[temp/2] = true;
                    dp[temp/2] = dp[temp] + 1;
                    from[temp/2] = temp;
                }else if(dp[temp/2] > dp[temp] + 1) {
                    dp[temp/2] = dp[temp] + 1;
                    from[temp/2] = temp;
                }
            }

            if(!visited[temp-1]) {
                q.offer(temp-1);
                visited[temp-1] = true;
                dp[temp-1] = dp[temp] + 1;
                from[temp-1] = temp;
            }else if(dp[temp-1] > dp[temp] + 1) {
                dp[temp-1] = dp[temp] + 1;
                from[temp-1] = temp;
            }
        }
        System.out.println(dp[1]);
        print(1);
        System.out.println(sb.substring(0,sb.length()-1));
        //System.out.println(Arrays.toString(from));
    }

    static void print(int num) {
        if(from[num] == 0) {
            sb.append(num).append(" ");
            return;
        }
        print(from[num]);
        sb.append(num).append(" ");
    }
}