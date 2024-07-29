/**
 * @author nakhoonchoi
 * @date 2024/07/29
 * @see https://www.acmicpc.net/problem/10211
 * @mem 15,364kb
 * @time 180ms
 * @caution
 * [고려사항]
 * 누적 합을 저장하는 dp 배열과 이중 반복문을 이용해서 문제를 해결하였다.
 * ex) 인덱스 5까지의 합 - 인덱스 1까지의 합 = arr[2] + arr[3] + arr[4] + arr[5]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <누적 합> 'Maximum Subarray'

public class BOJ10211 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] arr = new int[N+1];
            int [] dp = new int[N+1];
            int max = Integer.MIN_VALUE;

            for(int i=1;i<=N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = dp[i-1] + arr[i];
                max = Math.max(max, Math.max(arr[i], dp[i]));
            }

            for(int i=1;i<=N;i++){
                for (int j=1;j<i;j++) {
                    max = Math.max(max, dp[i]-dp[j]);
                }
            }
            System.out.println(max);
        }
    }
}