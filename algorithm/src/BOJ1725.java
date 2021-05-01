/**
 * @author nakhoon
 * @date May 1, 2021
 * @see https://www.acmicpc.net/problem/1725
 * @mem 25,084kb
 * @time 308ms
 * @caution
 * [고려사항]
 * 6549번 히스토그램에서 가장 큰 직사각형과 같은 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <스택> '히스토그램'
public class BOJ1725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] height = new int[N];

		long max = 0;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		//중간에 stack 맨 윗부분에 대한 높이보다 현재 높이가 낮을 경우에 대해 전부 계산
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
				int index = stack.pop();
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, (long) width * height[index]);
			}
			stack.push(i);
		}
		//끝 부분까지 스택에 들어가 있으므로 뽑아서 계산
		while (!stack.isEmpty()) {
			int index = stack.pop();
			int width = stack.isEmpty() ? N : N - stack.peek() - 1;
			max = Math.max(max, (long) width * height[index]);
		}

		System.out.println(max);
	}
}