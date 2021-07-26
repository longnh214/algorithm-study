/**
 * @author nakhoon
 * @date Jul 26, 2021
 * @see https://www.acmicpc.net/problem/9935
 * @mem 37,576kb
 * @time 496ms
 * @caution
 * [고려사항]
 * replace를 이용해서 푸는 방법만 생각했었는데 시간 초과가 발생했고,
 * 스택을 이용해서 풀 수 있다는 것이 신기했다. 
 * 스택에 문자를 넣을 때마다 판별해서 제거하면 효율적으로 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <스택,문자열> '문자열 폭발'
public class BOJ9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));
			
			if(stack.size() >= bomb.length()) {
				boolean flag = true;
				
				for(int j=0;j<bomb.length();j++) {
					if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					for(int j=0;j<bomb.length();j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(char ch : stack) {
			sb.append(ch);
		}
		
		System.out.println(sb.length() != 0 ? sb.toString() : "FRULA");
	}
}