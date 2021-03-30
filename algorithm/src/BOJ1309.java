import java.util.Scanner;

public class BOJ1309 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int [] dp = new int[input+1];

        dp[0] = 1;
        dp[1] = 3;
        for(int i=2;i<=input;i++){
            dp[i] = (dp[i-1] * 2 + dp[i-2])%9901;
        }

        System.out.println(dp[input]);
        scan.close();
    }
}
