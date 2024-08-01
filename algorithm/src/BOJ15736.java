/**
 * @author nakhoonchoi
 * @date 2024/08/01
 * @see https://www.acmicpc.net/problem/15736
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 제곱근의 정수값 만큼은 홀수만큼 깃발이 바뀔 것이므로
 * N의 제곱근을 정수로 표현하면 정답일 것이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '청기 백기'

public class BOJ15736 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.sqrt(N));
    }
}