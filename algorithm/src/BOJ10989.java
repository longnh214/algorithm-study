/**
 * @author nakhoon
 * @date 2022, 4월 27일
 * @see https://www.acmicpc.net/problem/10989
 * @mem 508,756kb
 * @time 2,488ms
 * @caution
 * [고려사항]
 * Arrays.sort로 문제를 해결했지만, 정석은 counting sort를 이용해서 문제를 푸는 것이 정해인 것 같다.
 * 수의 범위가 1000만 까지이므로 자릿수를 이용해서 정렬해야 한다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 <정렬> '수 정렬하기 3'
public class BOJ10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}