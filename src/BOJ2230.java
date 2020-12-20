/**
 * @author choi
 * @date Dec 20, 2020
 * @see https://www.acmicpc.net/problem/2230
 * @mem 25,820kb
 * @time 316ms
 * @caution
 * [고려사항]
 * while문 안의 조건이 헷갈려서 계속 틀렸던 문제이다...
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투포인터> '수 고르기'
public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        int answer = Integer.MAX_VALUE;

        while(left < N && right < N) {
            int output = arr[right] - arr[left];
            if(output > M) {
                answer = Math.min(answer, output);
                left++;
            }else if(output < M) {
                right++;
            }else {
                answer = Math.min(answer, output);
                break;
            }
        }
        System.out.println(answer);
    }
}