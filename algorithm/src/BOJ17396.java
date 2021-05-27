/**
 * @author nakhoon
 * @date May 27, 2021
 * @see https://www.acmicpc.net/problem/17396
 * @mem 153,064kb
 * @time 1020ms
 * @caution
 * [고려사항]
 * 다익스트라 문제를 오랜만에 풀어서 헤맸던 문제
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <다익스트라> '백도어'
public class BOJ17396 {
	static int [] isWard;
	static List<Route> [] routeList;
	static int N;
	static long [] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		routeList = new ArrayList[N];
		isWard = new int[N];
		distance = new long[N];
		for(int i=0;i<N;i++){
			routeList[i] = new ArrayList<>();
			isWard[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(distance, Long.MAX_VALUE);
		isWard[N-1] = 0;
		
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			routeList[start].add(new Route(end,cost));
			routeList[end].add(new Route(start,cost));
		}
		dijkstra();
		System.out.println(distance[N-1] == Long.MAX_VALUE ? -1 : distance[N-1]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Route> pq = new PriorityQueue<>();
		pq.offer(new Route(0,0));
		distance[0] = 0;
		while(!pq.isEmpty()) {
			Route temp = pq.poll();
			
			if(temp.end == N-1)
				return;
			
			if(isWard[temp.end] == 1)
				continue;
			
			for(Route next : routeList[temp.end]) {
				if(distance[next.end] > distance[temp.end] + next.cost && isWard[next.end] == 0) {
					distance[next.end] = distance[temp.end] + next.cost;
					pq.offer(new Route(next.end, distance[next.end]));
				}
			}
			isWard[temp.end] = 1;
		}
	}
	
	
	static class Route implements Comparable<Route>{
		int start;
		int end;
		long cost;
		Route(int start, int end, long cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		Route(int end, long cost){
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Route o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
	}
}