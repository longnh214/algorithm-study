import java.util.Scanner;

public class BOJ2167 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int value;
        int x1,y1,x2,y2;
        int T;
        int [][] dp = new int[n+1][m+1];//(0,0)~(x,y) 까지의 합을 저장하는 배열
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                value = scan.nextInt();
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + value;
            }
        }
        T = scan.nextInt();
        while(T-->0){
            x1 = scan.nextInt();
            y1 = scan.nextInt();
            x2 = scan.nextInt();
            y2 = scan.nextInt();
            System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
        }
        scan.close();
    }
}