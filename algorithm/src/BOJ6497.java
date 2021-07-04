/**
 * @author nakhoon
 * @date Jul 5, 2021
 * @see https://www.acmicpc.net/problem/6497
 * @mem 253,280kb
 * @time 1,012ms
 * @caution
 * [고려사항]
 * 입력 방식이 살짝 달라서 틀렸던 문제이다. 문제를 꼼꼼히 읽어야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <크루스칼> '전력난'
public class BOJ6497 {
	static int n,m;
	static int [] parent, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			long answer = 0;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) break;
			
			PriorityQueue<Road> pq = new PriorityQueue<>();
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				pq.offer(new Road(start,end,cost));
				
				answer += cost;
			}
			
			init();
			
			
			int count = 0;
			int MST = 0;
			while(!pq.isEmpty()) {
				Road temp = pq.poll();
				
				if(union(temp.start, temp.end)) {
					MST+=temp.cost;
					count++;
				}
				if(count == n-1) break;
			}
			System.out.println(answer - MST);
		}
		
	}
	
	public static void init() {
		parent = new int[n];
		rank = new int[n];
		
		for(int i=0;i<n;i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	public static int find(int n) {
		if(parent[n] == n) return n;
		else {
			return parent[n] = find(parent[n]);
		}
	}
	
	public static boolean union(int a,int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA == parentB) {
			return false;
		}else {
			if(rank[parentA] == rank[parentB]) {
				rank[parentA]++;
			}
			
			if(rank[parentA] > rank[parentB]){
				parent[parentB] = parent[parentA];
			}else {
				parent[parentA] = parent[parentB];
			}
			return true;
		}
	}
	
	static class Road implements Comparable<Road>{
		int start;
		int end;
		int cost;
		
		public Road(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}