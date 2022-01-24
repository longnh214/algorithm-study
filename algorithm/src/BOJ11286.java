/**
 * @author nakhoon
 * @date Jan 24, 2022
 * @see https://www.acmicpc.net/problem/11286
 * @mem 29,164kb
 * @time 752ms
 * @caution
 * [고려사항]
 * 절댓값을 기준으로 정렬하도록 Comparator 객체를 작성해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위 큐> '절댓값 힙'
public class BOJ11286 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2);
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});
		while(N-->0) {
			int command = Integer.parseInt(br.readLine());
			
			if(command == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(command);
			}
		}
	}
}