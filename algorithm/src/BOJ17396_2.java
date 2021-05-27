/**
 * @author nakhoon
 * @date May 27, 2021
 * @see https://www.acmicpc.net/problem/17396
 * @mem 166,092kb
 * @time 1140ms
 * @caution
 * [고려사항]
 * 다익스트라 문제를 오랜만에 풀어서 헤맸던 문제
 * 백도어 풀이 2
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <다익스트라> '백도어'
public class BOJ17396_2 {
	static int [] isWard;
	static List<Route> [] routeList;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		routeList = new ArrayList[N];
		isWard = new int[N];
		for(int i=0;i<N;i++){
			routeList[i] = new ArrayList<>();
			isWard[i] = Integer.parseInt(st.nextToken());
		}
		
		isWard[N-1] = 0;
		
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			routeList[start].add(new Route(end,cost));
			routeList[end].add(new Route(start,cost));
		}
		
		System.out.println(dijkstra());
	}
	
	public static long dijkstra() {
		PriorityQueue<Route> pq = new PriorityQueue<>();
		pq.offer(new Route(0,0));
		while(!pq.isEmpty()) {
			Route temp = pq.poll();
			
			if(temp.end == N-1)
				return temp.cost;
			
			if(isWard[temp.end] == 1)
				continue;
			
			for(Route next : routeList[temp.end]) {
				if(isWard[next.end] == 0) {
					pq.offer(new Route(next.end, temp.cost + next.cost));
				}
			}
			isWard[temp.end] = 1;
		}
		
		return -1;
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