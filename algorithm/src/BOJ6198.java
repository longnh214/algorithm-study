/**
 * @author nakhoon
 * @date Jul 24, 2021
 * @see https://www.acmicpc.net/problem/6198
 * @mem 22,672kb
 * @time 264ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <스택> '옥상 정원 꾸미기'
public class BOJ6198 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		long answer = 0;
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			//stack 맨 위의 값이 현재 건물 높이보다 작으면 stack에서 제외한다.
			//스택에서 제외한 건물 옥상에서 현재 건물을 볼 수 없기 때문
			while(!stack.isEmpty() && stack.peek() <= num) {
				stack.pop();
			}
			
			answer += stack.size();
			stack.push(num);
		}
		System.out.println(answer);
	}
}