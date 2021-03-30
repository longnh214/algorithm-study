import java.util.Scanner;

public class BOJ11048 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [][] arr = new int[n+1][m+1];
        int [][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                arr[i][j] = scan.nextInt();//입력받는 부분
                dp[i][j] = Math.max(Math.max(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + arr[i][j];//최댓값 판별 후 dp 배열에 저장
            }
        }
        System.out.println(dp[n][m]);//최댓값 출력
        scan.close();
    }
}