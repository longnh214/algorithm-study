/**
 * @author nakhoon
 * @date 2022, 5월 1일
 * @see https://www.acmicpc.net/problem/11656
 * @mem 17,540kb
 * @time 116ms
 * @caution
 * [고려사항]
 * String 클래스의 기본 정렬과 substring 함수를 통해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 <정렬> '접미사 배열'
public class BOJ11656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String [] arr = new String[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i] = str.substring(i, str.length());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}