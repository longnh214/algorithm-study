/**
 * @author nakhoon
 * @date Jul 10, 2021
 * @see https://www.acmicpc.net/problem/2812
 * @mem 39,784kb
 * @time 368ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '크게 만들기'
public class BOJ2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String number = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		stack.push(number.charAt(0));
		int count = 0;
		boolean flag = true;
		
		for(int i=1;i<number.length();i++) {
			char c = number.charAt(i);
			
			while(!stack.isEmpty() && flag) {
				if(count == K) {
					flag = false;
					break;
				}
				//스택의 맨 위의 값이 현재보다 작다면 pop
				if(stack.peek() < c) {
					stack.pop();
					count++;
				}
				//아니라면 반복문 탈출
				else {
					break;
				}
			}
			//현재 값을 스택에 무조건 넣는다.
			stack.push(c);
		}
		
		StringBuilder sb = new StringBuilder();
		if(count < K) {
			int remain = K - count;
			for(int i=0;i<stack.size() - remain;i++) {
				sb.append(stack.get(i));
			}
		}else {
			for(int i=0;i<stack.size();i++) {
				sb.append(stack.get(i));
			}
		}
		
		System.out.println(sb.toString());
	}
}