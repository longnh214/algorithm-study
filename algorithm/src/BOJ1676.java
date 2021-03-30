/**
 * @author nakhoon
 * @date Mar 29, 2021
 * @see https://www.acmicpc.net/problem/1676
 * @mem 11,496kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '팩토리얼 0의 개수'
public class BOJ1676 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while(true) {
            answer+=n/=5;
            if(n == 0) break;
        }
        System.out.println(answer);
    }
}