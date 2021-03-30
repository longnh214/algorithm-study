import java.util.Scanner;

public class BOJ9084 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int [] coin;//동전 종류 저장하는 배열
        int [] dp;//각 금액의 경우의 수를 저장하는 배열
        int money;//만들어야 할 금액을 저장하는 변수
        while(T-->0){
           coin = new int[scan.nextInt()];
           for(int i=0;i<coin.length;i++){
               coin[i] = scan.nextInt();
           }
           money = scan.nextInt();
           dp = new int[money+1];
           dp[0] = 1;//각 종류의 동전 1개의 값은 무조건 만들어진다.
           for(int i=0;i<coin.length;i++){
               for(int j=coin[i];j<=money;j++){
                   dp[j] += dp[j - coin[i]];
               }
           }
           System.out.println(dp[money]);
        }
        scan.close();
    }
}
