/**
 * @author nakhoon
 * @date 2022, 8월 07일
 * @see https://www.acmicpc.net/problem/25418
 * @mem 15,464kb
 * @time 108ms
 * @caution
 * [고려사항]
 * dp와 bfs를 이용해서 문제를 해결할 수 있는 문제인데, 그 중에서 dp를 이용해서 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 <DP> '정수 a를 k로 만들기'
public class BOJ25418 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int [] dp = new int[end+1];
        Arrays.fill(dp, end - start);
        dp[start] = 0;
        for(int i=start+1;i<=end;i++){
            if(i % 2 != 0){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
            }
        }
        System.out.println(dp[end]);
    }
}