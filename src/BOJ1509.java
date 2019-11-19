import java.util.Scanner;

//https://brenden.tistory.com/28 참고

public class BOJ1509 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().trim();
        int n = str.length();
        str = " " + str;
        //check[i][j]은 i 번째부터 j 번째까지 팰린드롬인지 확인하는 참거짓형 2차원 배열
        boolean [][] check = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++)
            check[i][i] = true; // 1자리 수는 무조건 팰린드롬

        for(int i=1;i<n;i++)//연속된 두 자리 수의 문자가 같을 경우 그 두 자리는 팰린드롬
            if(str.charAt(i) == str.charAt(i+1))
                check[i][i+1] = true;

        for(int i=2;i<=n;i++){
            for(int j=1;i+j<=n;j++){
                if(str.charAt(j) == str.charAt(i+j) && check[j+1][i+j-1])
                    check[j][i+j] = true;
            }
        }

        //dp[i] = i 번째 문자열까지를 팰린드롬 분할 했을 때, 분할의 최소 갯수
        //dp[i] = min(dp[j-1]) + 1
        int [] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = -1;
            for(int j=1;j<=i;j++){
               if(check[j][i])
                   if(dp[i] == -1 || dp[i] > dp[j-1] + 1)
                        dp[i] = dp[j-1] + 1;
            }
        }
        System.out.println(dp[n]);
        scan.close();
    }
}
