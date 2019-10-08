import java.util.Scanner;

public class BOJ9095 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int [] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        while(T-->0){
            int n = scan.nextInt();
            System.out.println(dp[n]);
        }
        scan.close();
    }
}