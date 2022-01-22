/**
 * @author nakhoon
 * @date Jan 22, 2022
 * @see https://www.acmicpc.net/problem/1927
 * @mem 34,120kb
 * @time 1,388ms
 * @caution
 * [고려사항]
 * 우선순위 큐를 이용해서 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위 큐> '최소 힙'
public class BOJ1927 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
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