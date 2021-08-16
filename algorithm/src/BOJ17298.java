/**
 * @author nakhoon
 * @date Aug 17, 2021
 * @see https://www.acmicpc.net/problem/17298
 * @mem 197,060kb
 * @time 996ms
 * @caution
 * [고려사항]
 * 스택을 적절히 이용해 문제를 해결할 수 있었다. 조건을 잘 생각해야 했던 문제.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <스택> '오큰수'
public class BOJ17298 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		int [] answer = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer[N-1] = -1; //마지막 수는 항상 오큰수가 없다.
		stack.push(arr[N-1]); //값을 미리 대입
		
		for(int i=N-2;i>=0;i--) {
			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty())
				answer[i] = -1;
			else
				answer[i] = stack.peek();
			stack.push(arr[i]);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb.substring(0, sb.length()-1));
	}
}