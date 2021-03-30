/**
 * @author choi
 * @date Sep 23, 2020
 * @see https://www.acmicpc.net/problem/17070
 * @mem 13,096kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 문제를 제대로 읽지 못해 대각선으로 가는 조건을 인식하지 못하고 문제를 풀어서 틀렸다가
 * 조건을 바로 추가했더니 답을 맞출 수 있었다.
 * dp로 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '파이프 만들기 1'
public class BOJ17070 {
    static int [][][] dp;
    static int [][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //0은 가로, 1은 오른아래 대각선, 2는 세로.
        dp = new int[N][N][3];
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