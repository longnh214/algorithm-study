/**
 * @author nakhoonchoi
 * @date 2024/11/05
 * @see https://softeer.ai/practice/6293
 * @caution
 * [고려사항]
 * 단순 LIS 문제였는데,,, dp 배열에 값을 넣고
 * dp 배열을 한 번 순회해서 최댓값을 구해야하는 걸 잊었다...
 * 마지막 수가 최장 길이 수열에 포함되지 않을 수도 있다는 것이 반례였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//소프티어 <연습문제> '징검다리'

public class Softeer6293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];
        int [] dp = new int[N];

        Arrays.fill(dp, 1);

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;
        for(int i=0;i<N;i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}