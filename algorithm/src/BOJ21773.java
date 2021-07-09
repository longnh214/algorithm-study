/**
 * @author nakhoon
 * @date Jul 9, 2021
 * @see https://www.acmicpc.net/problem/21773
 * @mem 172,780kb
 * @time 1,176ms
 * @caution
 * [고려사항]
 * 전체 프로세스 우선순위를 1씩 높이는 것보다는 들어갈 프로세스의 우선순위를 깎는 것이 더 효율적이다.
 * 프로세스를 한번 실행할 때마다 남은 실행시간도 1씩 깎아야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위큐> '가희와 프로세스 1'
public class BOJ21773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Process> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int priority = Integer.parseInt(st.nextToken());
			
			pq.offer(new Process(id,time,priority));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			if(pq.isEmpty()) {
				break;
			}
			Process cur = pq.poll();
			sb.append(cur.id + "\n");
			
			if(cur.time == 1)
				continue;
			
			//반대로 우선순위를 깎으며, 남은 실행시간도 1 깎는다.
			pq.offer(new Process(cur.id, cur.time - 1, cur.priority - 1));
		}
		
		System.out.println(sb.toString());
	}

	static class Process implements Comparable<Process>{
		int id;
		int time;
		int priority;
		
		public Process(int id, int time, int priority) {
			this.id = id;
			this.time = time;
			this.priority = priority;
		}

		@Override
		public int compareTo(Process o) {
			if(this.priority == o.priority) {
				return Integer.compare(this.id, o.id);
			}
			return Integer.compare(this.priority, o.priority) * -1;
		}
	}
}