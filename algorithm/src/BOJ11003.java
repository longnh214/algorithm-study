/**
 * @author nakhoon
 * @date Jul 7, 2021
 * @see https://www.acmicpc.net/problem/11003
 * @mem 996,536kb
 * @time 2,240ms
 * @caution
 * [고려사항]
 * LinkedList로 이루어진 덱으로는 메모리 초과가 났고, Array로 이루어진 덱으로는 통과했다...
 * LinkedList나 Stack으로 이루어진 Deque보다는 ArrayDeque이 더 빠르다고 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <덱> '최솟값 찾기'
public class BOJ11003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Number> deque = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			Number number = new Number(i,arr[i]);
			
			if(!deque.isEmpty() && deque.peekFirst().index <= i-L) {
				deque.pollFirst();
			}
			
			while(!deque.isEmpty() && deque.peekLast().value > number.value) {
				deque.pollLast();
			}
			
			deque.offer(number);
			sb.append(deque.peekFirst().value).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	static class Number{
		int index;
		int value;
		public Number(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
	}
}