/**
 * @author nakhoon
 * @date Feb 6, 2022
 * @see https://www.acmicpc.net/problem/2217
 * @mem 25,068kb
 * @time 364ms
 * @caution
 * [고려사항]
 * 정렬을 한 후 현재 로프의 중량 * 로프 개수 중 최대값을 답으로 출력했더니 맞았던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '로프'
public class BOJ2217 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer [] weight = new Integer[N];
		for(int i=0;i<N;i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(weight, Collections.reverseOrder());
		int count = 0;
		int answer = 0;
		for(int i=0;i<N;i++) {
			answer = Math.max(answer, weight[i] * (++count));
		}
		System.out.println(answer);
	}
}