import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());//testcase
        int page;//소설의 페이지 수
        int [] novel;
        int [] sum;
        int [][] dp;
        while(T-->0){
            page = Integer.parseInt(br.readLine());
            novel = new int[page+1];
            sum = new int[page+1];
            dp = new int[page+1][page+1];
            sum[0] = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=page;i++){
                novel[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + novel[i];

                for(int j=1;j<=page;j++){
                    dp[i][j] = 123456789;
                }
            }
            System.out.println(solve(dp,novel,sum,1,page));
        }
    }
    static int solve(int [][] dp, int [] novel, int [] sum, int start, int end){
        if (start >= end) {//자기 자신부터 자신까지는 비용이 없다.
            return 0;
        }
        if (end == start + 1) {//이웃한 경우
            return novel[start] + novel[end];
        }
        if (dp[start][end] < 123456789) {//값이 계산된 경우
            return dp[start][end];
        }
        for (int i = start; i < end; i++) {//안된경우 점화식 = dp[start][end] = Min(dp[start][k] + dp[k+1][end]) + sum[start~end];
            int temp = solve(dp, novel, sum, start, i) + solve(dp, novel, sum, i + 1, end) + sum[end] - sum[start - 1];
            dp[start][end] = Math.min(dp[start][end], temp);
        }
        return dp[start][end];
    }
}
