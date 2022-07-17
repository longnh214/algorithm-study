/**
 * @author nakhoon
 * @date 2022/07/17
 * @see https://www.acmicpc.net/problem/11568
 * @mem 12,200kb
 * @time 112ms
 * @caution
 * [고려사항]
 * LIS 문제였다. O(nlogn)으로 풀고 싶었지만 어려웠다...
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '민균이의 계략'
public class BOJ11568 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] arr = new int[N];
    int [] dp = new int[N];
    dp[0] = 1;
    int max = 1;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=1;i<N;i++){
      dp[i] = 1;
      for(int j=i;j>=0;j--){
        if(arr[i] > arr[j]){
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}