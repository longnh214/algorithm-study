/**
 * @author nakhoon
 * @date Sep 18, 2021
 * @see https://www.acmicpc.net/problem/21924
 * @mem 180,420kb
 * @time 1,136ms
 * @caution
 * [고려사항]
 * 오랜만에 푸는 MST 문제라 헷갈리는 부분이 있었다. 최소 간선은 N-1개이고, 우선순위큐를 이용하여 비용이 적은 간선부터 연결하면 되는 문제이다.
 * MST 문제를 보통 크루스칼로 해결하는데 프림 알고리즘도 학습해봐야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <MST> '도시 건설'
public class BOJ21924 {
	static int N;
	static int [] parent;
	static long sum, mstSum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sum = 0;
		mstSum = 0;
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		
		init();
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int count = 0;
		for(int i=0;i<M;i++) {
			st  = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(from, to, cost));
			
			sum += cost;
		}
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(union(cur.from, cur.to)) {
				count++;
				mstSum += cur.cost;
			}
			if(count ==  N-1) break;
		}
		System.out.println(isSameParent() ? sum - mstSum : -1);
		
	}
	
	public static void init() {
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
	}
	
	public static boolean isSameParent() {
		int standardParent = find(1);
		
		for(int i=2;i<=N;i++) {
			int curParent = find(i);
			
			if(standardParent != curParent) return false;
		}
		
		return true;
	}
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		return  parent[x] =  find(parent[x]);
	}
	
	public static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX == parentY) return false;
		
		if(x < y)
			parent[parentY] = parentX;
		else
			parent[parentX] = parentY;
		return true;
	}

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		public Edge(int from, int to, int cost) {
				this.from = from;
				this.to = to;
				this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}