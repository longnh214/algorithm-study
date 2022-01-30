/**
 * @author nakhoon
 * @date Jan 30, 2022
 * @see https://www.acmicpc.net/problem/4949
 * @mem 17,324kb
 * @time 324ms
 * @caution
 * [고려사항]
 * 스택을 이용해서 괄호가 맞는 지 확인을 한 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <스택> '균형잡힌 세상'
public class BOJ4949 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		outer: while(!(str = br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<str.length();i++) {
				char c = str.charAt(i);
				switch(c) {
				case '(':
					stack.push('(');
					break;
				case ')':
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}else {
						System.out.println("no");
						continue outer;
					}
					break;
				case '[':
					stack.push('[');
					break;
				case ']':
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					}else {
						System.out.println("no");
						continue outer;
					}
					break;
				}
			}
			if(stack.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}