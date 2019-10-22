import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ2688 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        long [][] dp = new long[65][10];

        while(T-->0){
            int n = scan.nextInt();
            for(int j=0;j<10;j++){
                dp[1][j] = j+1;
            }

            for(int i=2;i<=n;i++){
                dp[i][0] = 1;
                for(int j=1;j<10;j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            System.out.println(dp[n][9]);
        }
    }
}
