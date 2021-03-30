import java.util.Scanner;

public class BOJ1932 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();//크기
        int max = 0;//최대값을 저장하는 변수
        int [][] dp = new int[size+1][size+1];
        for(int i=1;i<=size;i++){
            for(int j=1;j<=i;j++){
                dp[i][j] = scan.nextInt();
                if(j == 1) dp[i][j] += dp[i-1][j];//왼쪽 끝
                else if (j == i) dp[i][j] += dp[i-1][j-1];//오른쪽 끝
                else dp[i][j] += Math.max(dp[i-1][j-1],dp[i-1][j]);//사잇수
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
        scan.close();
    }
}
