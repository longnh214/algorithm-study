import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int [][] arr = new int[size+1][3]; //0:r/1:g/2:b
        int [][] dp = new int[size+1][3];
        StringTokenizer st = null;
        for(int i=1;i<=size;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=size;i++){//이전 dp 값 중 최소 + 현재 비용 값 = 현재 dp 값
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][2];
        }
        //dp 값중 최소 출력
        System.out.println(Math.min(Math.min(dp[size][0],dp[size][1]),dp[size][2]));
    }
}