/**
 * @author nakhoonchoi
 * @date 2024/09/12
 * @see https://www.acmicpc.net/problem/2015
 * @mem 32,788kb
 * @time 268ms
 * @caution
 * [고려사항]
 * 누적 합과 맵을 이용해서 해결했다.
 * sum[i] - sum[j-1] 는 j부터 i 까지의 부분합이며,
 * sum[i] - sum[j-1] = K인 경우의 수를 전부 찾으면 된다.
 * 순회하면서 sum[i] - K의 개수를 누적해서 맵에 더해주면 AC를 받을 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <누적 합> '수들의 합 4'

public class BOJ2015 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        long answer = 0;

        int [] arr = new int[N+1];
        int [] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        for(int i=1;i<=N;i++){
            if(sum[i] == target) {
                answer++;
            }

            answer += countMap.getOrDefault(sum[i] - target, 0);
            countMap.put(sum[i], countMap.getOrDefault(sum[i], 0) + 1);
        }

        System.out.println(answer);
    }
}