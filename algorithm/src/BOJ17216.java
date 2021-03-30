/**
 * @author choi
 * @date Nov 8, 2020
 * @see https://www.acmicpc.net/problem/17216
 * @mem 11,868kb
 * @time 300ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '가장 큰 감소 부분 수열'
public class BOJ17216{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int size;
        int [] arr;//문제 배열
        long [] dp;//수열의 길이를 세기 위한 배열
        long max = 0; //수열의 합 최대값
        size = Integer.parseInt(br.readLine());
        arr = new int[size];
        dp = new long[size];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }
        max = dp[0];
        for(int i=1;i<size;i++){
            for(int j=0;j<i;j++){
                if(arr[i] < arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
            max = Math.max(max,dp[i]);//각 dp 값 중에 최대값을 구한다.
        }
        System.out.println(max);
    }
}