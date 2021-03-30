/**
 * @author choi
 * @date Dec 20, 2020
 * @see https://www.acmicpc.net/problem/1806
 * @mem 23,168kb
 * @time 216ms
 * @caution
 * [고려사항]
 * 합이 기준값보다 클 때, 작을 때를 분기로 나누어서 처리하고, end의 범위를 벗어나면 break
 * 를 하여 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투포인터> '부분합'
public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        while(true) {
            if(sum >= S){
                answer = Math.min(answer, end-start);
                sum -= arr[start];
                start++;
            }else if(end == N) {
                break;
            }else{
                sum += arr[end];
                end++;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}