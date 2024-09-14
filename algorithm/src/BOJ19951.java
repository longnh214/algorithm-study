/**
 * @author nakhoonchoi
 * @date 2024/09/14
 * @see https://www.acmicpc.net/problem/19951
 * @mem 75,740kb
 * @time 524ms
 * @caution
 * [고려사항]
 * {n, 0, 0, -n} 누적합을 이용해 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <누적 합> '태상이의 훈련소 생활'

public class BOJ19951 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        int [] temp = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());

            temp[start] += degree;
            if(end < N){
                temp[end] += (degree * -1);
            }
        }

        for(int i=1;i<N;i++){
            temp[i] += temp[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            arr[i] += temp[i];
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}