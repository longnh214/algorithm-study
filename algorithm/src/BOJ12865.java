/**
 * @author nakhoonchoi
 * @date 2025/02/06
 * @see https://boj.ma/12865
 * @mem 54,308kb
 * @time 188ms
 * @caution
 * [고려사항]
 * 냅색 배낭 문제였다.
 * 물건은 배낭에 0개 아니면 1개만 들어갈 수 있다.
 * 2차원 배열로 DP를 선언해서 'dp[확인한 물건의 개수][차지한 무게] = 최대 가치' 를 저장한다.
 * 각 물건을 순회하며 차지한 무게에 대한 최대 가치를 갱신해서 모든 물건을 확인했을 때 dp[N][K] 값을 출력하면 된다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DP> '평범한 배낭'

public class BOJ12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] dp = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for(int j=0;j<=K;j++){
                dp[i][j] = dp[i-1][j];
            }
            for(int j=W;j<=K;j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W] + V);
            }
        }

        System.out.println(dp[N][K]);
    }
}