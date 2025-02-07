/**
 * @author nakhoonchoi
 * @date 2025/02/07
 * @see https://boj.ma/9184
 * @mem 64,496kb
 * @time 1,392ms
 * @caution
 * [고려사항]
 * dp 함수를 그대로 Java 함수로 가져왔고, 값을 메모이제이션해서 이미 계산된 값이라면 dp 배열에서 가져올 수 있도록 구현하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DP> '신나는 함수 실행'

public class BOJ9184 {
    static int [][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1){
                break;
            }

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a,b,c));
        }
    }

    public static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }

        if(a > 20 || b > 20 || c > 20){
            return w(20, 20, 20);
        }

        if(dp[a][b][c] != 0){
            return dp[a][b][c];
        }

        if(a < b && b < c){
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return dp[a][b][c];
        }

        dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return dp[a][b][c];
    }
}