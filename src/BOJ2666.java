import java.util.*;

//https://lyzqm.blogspot.com/2017/03/2666.html 참고 어려움..
public class BOJ2666 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int [][] dp = new int[21][21];//[벽장순서][나머지 index]
        int size; //전체 벽장 크기
        int [] op = new int[2]; //열린 문 좌표 저장
        int count; //열어야하는 벽장 수
        int [] quest;

        size = scan.nextInt();

        for(int i=0;i<op.length;i++){
            op[i] = scan.nextInt();
        }

        quest = new int[size+1];

        count = scan.nextInt();

        for(int i=1;i<=count;i++){
            quest[i] = scan.nextInt();
        }

        for(int i=1;i<21;i++){
             for(int j=1;j<21;j++){
                 dp[i][j] = -1;
             }
        }

        dp[1][op[1]] = Math.abs(op[0] - quest[1]);
        dp[1][op[0]] = Math.abs(op[1] - quest[1]);

        for (int n = 1; n < count; n++){    //열어야하는 벽장 크기만큼(순서대로)
            for (int m = 1; m <= size; m++){
                if (dp[n][m] != -1 && quest[n] != m){
                    int first, second;
                    first = dp[n][m] + Math.abs(quest[n] - quest[n + 1]);
                    second = dp[n][m] + Math.abs(m - quest[n + 1]);
                    if (dp[n + 1][m] != -1){
                        first = Math.min(dp[n + 1][m], first);
                    }
                    if (dp[n + 1][quest[n]] != -1){
                        second = Math.min(dp[n + 1][quest[n]], second);
                    }
                    dp[n + 1][m] = first;
                    dp[n + 1][quest[n]] = second;
                }
            }
        }
        int ans = 123456789;
        for (int n = 1; n <= size; n++){
            if (dp[count][n] != -1)
                ans = Math.min(ans, dp[count][n]);
        }
        System.out.println(ans);
        scan.close();
    }
}
