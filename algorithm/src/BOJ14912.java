/**
 * @author nakhoon
 * @date 2022년 9월 25일
 * @see https://www.acmicpc.net/problem/14912
 * @mem 24,916kb
 * @time 236ms
 * @caution
 * [고려사항]
 * 1부터 N까지의 수를 모두 문자열로 합치고, target 숫자를 공백으로 replace 시켜서 두 문자열의 길이 차이를 출력했을 때 AC를 받을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <완전 탐색> '숫자 빈도수'
public class BOJ14912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(i);
        }
        int length = sb.length();
        sb = new StringBuilder(sb.toString().replaceAll(String.valueOf(M), ""));
        System.out.println(length - sb.length());
    }
}