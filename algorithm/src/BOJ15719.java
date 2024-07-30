/**
 * @author nakhoonchoi
 * @date 2024/07/30
 * @see https://www.acmicpc.net/problem/15719
 * @mem 165,516kb
 * @time 304ms
 * @caution
 * [고려사항]
 * 주어진 배열의 합과 1부터 N까지의 합의 차이로 답을 구하는 알고리즘은 알았으나,
 * 입력 받는 과정에서 메모리 초과를 해결할 수 없어
 * https://gist.github.com/KSH-code/b670b25e98c02ce95127371869fe79c5
 * 해당 페이지를 참고하여 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '중복된 숫자'

public class BOJ15719 {
    private static byte[] buffer = new byte[78888905];
    private static int next;
    private static int b;
    public static void main(String args[]) throws IOException {
        System.in.read(buffer, 0, buffer.length);
        long N = nextInt();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nextInt();
        }
        // sum - n(n - 1) / 2 = m
        System.out.println(sum - (N * (N - 1) / 2));
    }
    private static long nextInt() {
        long n = buffer[next++] - '0';
        while ((b = buffer[next++]) >= '0')
            n = (n * 10) + (b - '0');
        return n;
    }
}