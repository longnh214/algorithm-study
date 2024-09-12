/**
 * @author nakhoonchoi
 * @date 2024/09/13
 * @see https://www.acmicpc.net/problem/10986
 * @mem 175,664kb
 * @time 432ms
 * @caution
 * [고려사항]
 * 누적 합 중 나머지가 같은 두 합을 빼면 M과 나눌 때 나머지가 0이 된다...
 * 나머지 별로 숫자가 몇 개인지 배열에 저장해두고 계산할 때 포함시키면 된다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <누적 합> '나머지 합'

public class BOJ10986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long answer = 0;

        long [] arr = new long[N+1];
        long [] sum = new long[N+1];
        long [] count = new long[M];
        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken()) % M;
            sum[i] = (arr[i] + sum[i-1]) % M;
        }

        for(int i=1;i<=N;i++){
            if(sum[i] % M == 0){
                answer++;
            }
            count[(int)(sum[i] % M)]++;
        }

        for(int i=0;i<M;i++){
            if(count[i] > 1){
                answer += count[i] * (count[i] - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}