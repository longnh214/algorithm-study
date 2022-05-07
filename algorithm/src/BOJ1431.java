/**
 * @author nakhoon
 * @date 2022, 5월 7일
 * @see https://www.acmicpc.net/problem/1431
 * @mem 18,324kb
 * @time 228ms
 * @caution
 * [고려사항]
 * 문자열의 정렬 기준을 설정해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 <정렬> '시리얼 번호'
public class BOJ1431 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() == o2.length()){
                int first = 0;
                int second = 0;
                for(int i=0;i<o1.length();i++){
                    if(Character.isDigit(o1.charAt(i))){
                        first += (o1.charAt(i) - '0');
                    }
                    if(Character.isDigit(o2.charAt(i))){
                        second += (o2.charAt(i) - '0');
                    }
                }
                if(first == second){
                    return o1.compareTo(o2);
                }else{
                    return Integer.compare(first, second);
                }
            }
            return Integer.compare(o1.length(), o2.length());
        });
        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}