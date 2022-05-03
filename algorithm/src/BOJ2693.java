/**
 * @author nakhoon
 * @date 2022, 5월 3일
 * @see https://www.acmicpc.net/problem/2693
 * @mem 12,984kb
 * @time 120ms
 * @caution
 * [고려사항]
 * 내림차순으로 정렬해서 3번째의 수를 출력해주는 방식으로 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 <정렬> 'N번째 큰 수'
public class BOJ2693 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer[10];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++){
                arr[j] = new Integer(Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2) * -1;
                }
            });
            sb.append(arr[2]).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}