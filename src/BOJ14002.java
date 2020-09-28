/**
 * @author choi
 * @date Sep 29, 2020
 * @see https://www.acmicpc.net/problem/14002
 * @mem 13,544kb
 * @time 104ms
 * @caution
 * [고려사항]
 * 11053번 가장 긴 증가하는 부분 수열에서 지금까지 지나온 루트를 저장하는 배열에 메모이제이션하
 * 지나쳐 온 경로를 출력할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '가장 긴 증가하는 부분 수열 4'
public class BOJ14002 {
    static int [] num;
    static int [] dp;
    static int [] from;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        dp = new int[N];
        from = new int[N];

        Arrays.fill(from, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for(int i=1;i<N;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(num[j] < num[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    from[i] = j;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=0;i<dp.length;i++) {
            if(max < dp[i]) {
                maxIndex = i;
                max = dp[i];
            }
        }
        from(maxIndex);
        System.out.println(max);
        System.out.println(sb.toString());
    }

    public static void from(int index) {
        if(from[index] == -1) {
            sb.append(num[index]).append(" ");
        }else {
            from(from[index]);
            sb.append(num[index]).append(" ");
        }
    }
}