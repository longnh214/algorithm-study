/**
 * @author nakhoon
 * @date 2022, 8월 21일
 * @see https://www.acmicpc.net/problem/2556
 * @mem 11,648kb
 * @time 92ms
 * @caution
 * [고려사항]
 * *로 정사각형을 찍는 문제였다. 적절히 찍는다 라는 의미는 너무 어렵다... 넌센스도 아니고
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <구현> '별 찍기 - 14'
public class BOJ2556 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}