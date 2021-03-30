/**
 * @author choi
 * @date Sep 24, 2020
 * @see https://www.acmicpc.net/problem/17069
 * @mem 13,344kb
 * @time 92ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '파이프 만들기 2'
public class BOJ17069 {
    static long [][][] dp;
    static int [][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //0은 가로, 1은 오른아래 대각선, 2는 세로.
        dp = new long[N][N][3];
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][0] = 1;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] != 1) {
                    if(j-1 >= 0) {
                        dp[i][j][0] += dp[i][j-1][0];
                        dp[i][j][0] += dp[i][j-1][1];
                    }
                    if(i-1 >= 0) {
                        dp[i][j][2] += dp[i-1][j][1];
                        dp[i][j][2] += dp[i-1][j][2];
                    }
                    if(i-1 >= 0 && j-1 >= 0 && map[i-1][j] == 0 && map[i][j-1] == 0) {
                        dp[i][j][1] += dp[i-1][j-1][0];
                        dp[i][j][1] += dp[i-1][j-1][1];
                        dp[i][j][1] += dp[i-1][j-1][2];
                    }
                }
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}