/**
 * @author choi
 * @date 2020. 8. 5
 * @see https://www.acmicpc.net/problem/5014
 * @mem 56,856kb
 * @time 164ms
 * @caution
 * [고려사항] 각 dp 배열 인덱스에 갈 수 있는 최소의 버튼을 저장해서 bfs를 이용해 각 인덱스에 값을 저장해주었습니다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <BFS> - '스타트링크'
public class BOJ5014 {
    static int F,S,G,U,D;
    static String answer;
    static int [] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = "";
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dp = new int[F+1];
        //-1은 갈 수 없다.
        Arrays.fill(dp, -1);
        bfs(S);
        if(dp[G] != -1)
            System.out.println(dp[G]);
        else
            System.out.println("use the stairs");
    }
    //bfs를 이용해 dp 배열에 값(각 층에 갈 수 있는 최소 버튼 수)을 넣는다.
    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(node);
        dp[node]++;
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(isIn(temp+U) && dp[temp+U] == -1) {
                dp[temp+U] = dp[temp]+1;
                q.offer(temp+U);
            }
            if(isIn(temp-D) && dp[temp-D] == -1) {
                dp[temp-D] = dp[temp]+1;
                q.offer(temp-D);
            }
        }
    }
    //범위 안에 있는가.
    public static boolean isIn(int node) {
        return node>=1 && node<=F;
    }
}