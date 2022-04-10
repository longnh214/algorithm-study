/**
 * @author nakhoon
 * @date 2022, 4월 10일
 * @see https://www.acmicpc.net/problem/17484
 * @mem 11,588kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 진우의 달 여행 (Large) 와 똑같은 코드로 제출하였다. --17485번--
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <DP> '진우의 달 여행 (Small)'
public class BOJ17484 {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] fuel = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                fuel[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][][] dp = new int[3][N][M];

        //0 : 우하단 대각
        //1 : 바로 아래
        //2 : 좌하단 대각
        //init
        for(int i=0;i<M;i++){
            dp[0][0][i] = fuel[0][i];
            dp[1][0][i] = fuel[0][i];
            dp[2][0][i] = fuel[0][i];
        }

        //올 수 없는 경우에는 최대값으로 초기화
        for(int i=0;i<N;i++){
            dp[0][i][0] = Integer.MAX_VALUE;
            dp[2][i][M-1] = Integer.MAX_VALUE;
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<M;j++){
                if(isValid(j-1) && isValid(j+1)){
                    dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1]) + fuel[i][j];
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + fuel[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1]) + fuel[i][j];
                }else if(!isValid(j-1) && isValid(j+1)){
                    //왼쪽 끝에 있는 경우
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + fuel[i][j];
                    dp[2][i][j] = Math.min(dp[0][i-1][j+1], dp[1][i-1][j+1]) + fuel[i][j];
                }else if(isValid(j-1) && !isValid(j+1)){
                    //오른쪽 끝에 있는 경우
                    dp[0][i][j] = Math.min(dp[1][i-1][j-1], dp[2][i-1][j-1]) + fuel[i][j];
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + fuel[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<M;i++){
            for(int j=0;j<3;j++){
                answer = Math.min(answer, dp[j][N-1][i]);
            }
        }

        System.out.println(answer);
    }

    public static boolean isValid(int y){
        return y>=0 && y<M;
    }
}
