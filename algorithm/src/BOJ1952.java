/**
 * @author nakhoonchoi
 * @date 2025/03/26
 * @see https://boj.ma/1952
 * @mem 11,552kb
 * @time 64ms
 * @caution
 * [고려사항]
 * N과 M 중에 최솟값, 그리고 둘 중에 어떤 값이 최소인 지가 중요했다.
 * 직접 그림을 그리면서 규칙을 찾아갔다.
 * 달팽이 3번 문제를 풀기 위한 초석이 된 문제다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '달팽이 2'

public class BOJ1952 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long min = Math.min(N, M);

        boolean isSmallAndEqualN = N <= M;
        long spinCount = isSmallAndEqualN ? 2 * (min - 1) : 2 * min - 1;

        System.out.println(spinCount);
    }
}