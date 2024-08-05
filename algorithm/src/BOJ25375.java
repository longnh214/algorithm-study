/**
 * @author nakhoonchoi
 * @date 2024/08/05
 * @see https://www.acmicpc.net/problem/25375
 * @mem 67,836kb
 * @time 1,952ms
 * @caution
 * [고려사항]
 * gcd를 구해야하나...? 했던 문제이지만 시간초과가 발생했고,
 * 결론은 gcd를 구하는 문제가 아니라 a와 b의 특정 조건이 맞는 지
 * 아닌 지 판별해야했던 문제였다... 문제 제목대로 정말 간단한 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '아주 간단한 문제'

public class BOJ25375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (b > a && b % a == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}