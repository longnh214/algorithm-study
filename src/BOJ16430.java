/**
 * @author choi
 * @date Oct 4, 2020
 * @see https://www.acmicpc.net/problem/16430
 * @mem 12,980kb
 * @time 84ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '제리와 톰'
public class BOJ16430 {
    static int A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println((B-A) + " " + B);
    }
}