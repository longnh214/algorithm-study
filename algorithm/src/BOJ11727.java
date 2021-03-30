import java.util.Scanner;

public class BOJ11727 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] dp = new int[1001];
        int n;
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            dp[i] = (dp[i-2] * 2 + dp[i-1])%10007;
        }
        n = scan.nextInt();
        System.out.println(dp[n]);
        scan.close();
    }
}