/**
 * @author nakhoon
 * @date Jan 23, 2022
 * @see https://www.acmicpc.net/problem/11279
 * @mem 34,288kb
 * @time 1,680ms
 * @caution
 * [고려사항]
 * 우선순위 큐에 정렬 기준을 이용해서 생성자를 선언해서 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위 큐> '최대 힙'
public class BOJ11279 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1,o2) * -1;
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