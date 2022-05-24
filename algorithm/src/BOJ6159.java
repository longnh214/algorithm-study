/**
 * @author nakhoon
 * @date 2022, 5월 24일
 * @see https://www.acmicpc.net/problem/6159
 * @mem 16,048kb
 * @time 280ms
 * @caution
 * [고려사항]
 * 정렬 이후 이중 for문을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 <정렬> '코스튬 파티'
public class BOJ6159 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer = 0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(arr[i] + arr[j] <= S){
                    answer++;
                }else{
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}