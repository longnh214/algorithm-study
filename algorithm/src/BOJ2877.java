/**
 * @author nakhoon
 * @date Jul 4, 2021
 * @see https://www.acmicpc.net/problem/2877
 * @mem 11,428kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 2진수를 이용하여 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '4와 7'
public class BOJ2877 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		K++;
		
		Stack<Integer> stack = new Stack<>();
		while(K != 0) {
			stack.push(K % 2);
			K /= 2;
		}
		stack.pop();
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			int value = stack.pop();
			if(value == 0) {
				sb.append(4);
			}else {
				sb.append(7);
			}
		}
		System.out.println(sb.toString());
	}
}