import java.util.Scanner;

public class BOJ11052 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int [] arr = new int[size+1];
        int [] dp = new int[size+1];
        for(int i=1;i<=size;i++){
            arr[i] = scan.nextInt();
        }
        for(int i=1;i<=size;i++){
            for(int j=i;j<=size;j++){
                if(dp[j-i] + arr[i] > dp[j])//최대값이 아니면 값을 바꾸지 않는다.
                    dp[j] = dp[j-i] + arr[i];
            }
        }
        System.out.println(dp[size]);
        scan.close();
    }
}
