/**
 * @author nakhoon
 * @date Jul 1, 2021
 * @see https://www.acmicpc.net/problem/1461
 * @mem 11,856kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 우선순위큐를 두개 이용해서 풀었다. 절대값에 따라 가장 먼 곳부터 M개 만큼 책을 가져와야 최적의 거리가 나온다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '도서관'
public class BOJ1461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> minusPq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2) * -1;
			}
			
		});
		
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2) * -1;
			}
			
		});
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 0) {
				plusPq.offer(num);
			}else {
				minusPq.offer(Math.abs(num));
			}
		}
		
		int max = Integer.MIN_VALUE;
		if(plusPq.isEmpty()) {
			max = Math.abs(minusPq.peek());
		}else if(minusPq.isEmpty()) {
			max = Math.abs(plusPq.peek());
		}else {
			max = Math.max(Math.abs(minusPq.peek()), Math.abs(plusPq.peek()));
		}
		
		int answer = 0;
		while(!minusPq.isEmpty()) {
			int temp = minusPq.poll();
			
			for(int i=0;i<M-1;i++) {
				minusPq.poll();
				
				if(minusPq.isEmpty()) {
					break;
				}
			}
			answer += temp * 2;
		}
		
		while(!plusPq.isEmpty()) {
			int temp = plusPq.poll();
			
			for(int i=0;i<M-1;i++) {
				plusPq.poll();
				
				if(plusPq.isEmpty()) {
					break;
				}
			}
			answer += temp * 2;
		}
		
		answer -= max;
		System.out.println(answer);
	}
}