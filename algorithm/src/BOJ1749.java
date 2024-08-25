/**
 * @author nakhoonchoi
 * @date 2024/08/25
 * @see https://www.acmicpc.net/problem/1749
 * @mem 19,012kb
 * @time 648ms
 * @caution
 * [고려사항]
 * 누적 합과 메모이제이션을 이용해서 문제를 해결하였다.
 * dp 이차원 배열에 에 1,1 부터 N,M까지의 누적 합을 저장해주었고,
 * 완전탐색을 하며 점화식을 적용해서 부분수열의 합을 구해주었다.
 * -10,000까지 값이 저장될 수 있기에 answer는 Integer.MIN_VALUE로 초기화해주었고,
 * 부분수열 중에는 자기 자신도 있기 때문에 체크해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DP> '점수따먹기'

public class BOJ1749 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] arr = new int[N+1][M+1];
        int [][] dp = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                for(int k=1;k<=i;k++){
                    for(int l=1;l<=j;l++){
                        int val = dp[i][j] - dp[k-1][j] - dp[i][l-1] + dp[k-1][l-1];
                        answer = Math.max(answer, val);
                    }
                }
                answer = Math.max(answer, arr[i][j]);
            }
        }
        System.out.println(answer);
    }
}