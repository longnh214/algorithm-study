/**
 * @author choi
 * @date Dec 16, 2020
 * @see https://www.acmicpc.net/problem/2559
 * @mem 22,484kb
 * @time 216ms
 * @caution
 * [고려사항]
 * 투 포인터를 익히기에 좋은 문제였다. start, end 변수(배열 인덱스)를 잘 관리해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투포인터> '수열'
public class BOJ2559 {
    static int N,K,answer,start,end,sum;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        start = 0;
        end = K;
        sum = 0;
        for(int i=start;i<end;i++) {
            sum += arr[i];
        }
        answer = sum;
        while(end < N) {
            sum -= arr[start];
            start++;
            sum += arr[end];
            end++;
            if(sum > answer) answer = sum;
        }

        System.out.println(answer);
    }
}