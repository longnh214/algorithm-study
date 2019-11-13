import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int [] arr = new int[size+1];
        int [] dp = new int[size+1];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        for(int i=1;i<size;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }
        for(int i=0;i<size;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
