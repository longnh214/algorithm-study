/**
 * @author nakhoon
 * @date 2022, 4월 28일
 * @see https://www.acmicpc.net/problem/1427
 * @mem 18,444kb
 * @time 224ms
 * @caution
 * [고려사항]
 * 문자열을 받아서 Integer 배열로 변환하고, 배열을 내림차순으로 정렬한 뒤에 출력해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 <정렬> '소트인사이드'
public class BOJ1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer [] arr = new Integer[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i] = str.charAt(i) - '0';
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1, o2) * -1);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}