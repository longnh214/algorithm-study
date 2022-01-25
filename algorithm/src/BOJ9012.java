/**
 * @author nakhoon
 * @date Jan 25, 2022
 * @see https://www.acmicpc.net/problem/9012
 * @mem 11,712kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <스택> '괄호'
public class BOJ9012 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		outer: while(N-->0) {
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			
			for(int i=0;i<str.length();i++) {
				char c = str.charAt(i);
				
				if(c == '(') {
					stack.push(c);
				}else {
					if(stack.isEmpty()) {
						System.out.println("NO");
						continue outer;
					}else {
						stack.pop();
					}
				}
			}
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}