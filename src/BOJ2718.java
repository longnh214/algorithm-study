import java.util.Scanner;

public class BOJ2718 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int n;
        int [][] dp = new int[10001][16];//벽돌의 상황을 비트로 저장해둘 2차원 배열 [i][j]를 보면 i번째 벽돌에 비트 j의 상태
        dp[0][15] = 1;//벽돌이 생기기 전에 앞 칸(i-2칸까지)전부 채워져있다고 가정해야하는 초기화
        for(int i=1;i<10001;i++){
            for(int j=0;j<16;j++){//예외 없는 경우(i-1,i칸에 1*2 벽돌만 쓰는 경우)
                dp[i][j] = dp[i-1][15-j];
            }
            //2*1 벽돌을 한번이라도 쓰는 경우(i-1,i칸에)
            dp[i][3] += dp[i-1][15];
            dp[i][6] += dp[i-1][15];
            dp[i][7] += (dp[i-1][11] + dp[i-1][14]);
            dp[i][11] += dp[i-1][7];
            dp[i][12] += dp[i-1][15];
            dp[i][13] += dp[i-1][14];
            dp[i][14] += (dp[i-1][13] + dp[i-1][7]);
            dp[i][15] += (dp[i-1][3] + dp[i-1][6] + dp[i-1][12] + dp[i-1][15]);
        }
        for(int t=0;t<T;t++){
            n = scan.nextInt();
            System.out.println(dp[n][15]);
        }
        scan.close();
    }
}
