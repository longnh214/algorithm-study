/**
 * @author nakhoon
 * @date 2022, 3월 8일
 * @see https://www.acmicpc.net/problem/11508
 * @mem 26,460kb
 * @time 368ms
 * @caution
 * [고려사항]
 * 최소값을 빼는 문제인 줄 알고 정렬 한 뒤에 N/3개의 수를 전체 sum에서 빼주는 방식으로 문제를 풀었는데,
 * 전체 합의 최솟값을 구하는 문제라는 것을 인지한 뒤에는 먼저 내림차순으로 정렬하고, 인덱스의 3 나눈 값이 2인 인덱스의 수 빼고
 * 모든 수를 더함으로써 답을 도출해낼 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//백준 <그리디> '2+1 세일'
public class BOJ11508 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer[N];
        int sum = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<N;i++){
            if(i % 3 != 2) sum += arr[i];
        }
        System.out.println(sum);
    }
}