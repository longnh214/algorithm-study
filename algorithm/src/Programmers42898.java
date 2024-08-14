/**
 * @author nakhoonchoi
 * @date 2024/08/14
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * @mem
 * @time
 * @caution
 * [고려사항]
 * dp의 메모이제이션을 이용해서 문제를 풀었다.
 * m과 n, 물 웅덩이의 좌표가 행열 순이 아니라 열행 순으로 숫자가 표기되어있어서
 * 문제를 계속 틀렸다.
 * 반대로 고쳤더니 AC를 받을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
//프로그래머스 <DP> '등굣길'

public class Programmers42898 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int [][] puddles = {{2,2}};

        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int [][] arr = new int[n][m];
        int [][] dp = new int[n][m];
        int MOD = 1_000_000_007;

        for(int i=0;i<puddles.length;i++){
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;

            arr[y][x] = 1;
        }

        dp[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 1){
                    dp[i][j] = 0;
                }
                if((!(i == 0 && j == 0)) && isIn(i-1, j, n, m)){
                    dp[i][j] += ((arr[i-1][j] == 1 ? 0 : dp[i-1][j]) % MOD);
                }
                if((!(i == 0 && j == 0)) && isIn(i, j-1, n, m)){
                    dp[i][j] += ((arr[i][j-1] == 1 ? 0 : dp[i][j-1]) % MOD);
                }
            }
        }

        return dp[n-1][m-1] % MOD;
    }

    public static boolean isIn(int x, int y, int m, int n){
        return x>=0 && x<m && y>=0 && y<n;
    }
}
