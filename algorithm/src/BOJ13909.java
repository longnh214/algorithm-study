/**
 * @author nakhoonchoi
 * @date 2024/07/25
 * @see https://www.acmicpc.net/problem/13909
 * @mem 11,476kb
 * @time 72ms
 * @caution
 * [고려사항]
 * 규칙에 의해 N의 제곱근 만큼의 수는 약수가 홀수이기 때문에
 * 창문이 열린다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '창문 닫기'

public class BOJ13909 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.sqrt(N));
    }
}