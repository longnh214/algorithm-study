/**
 * @author choi
 * @date Jul 14, 2021
 * @see https://www.acmicpc.net/problem/11779
 * @mem 50,568kb
 * @time 412ms
 * @caution
 * [고려사항]
 * 지나가는 경로마다 문자열에 +를 해주어 계속 String 배열을 갱신하는 방법으로는 계속 틀렸고,
 * 스택과 부모의 인덱스를 저장하는 int 배열을 이용했더니 맞출 수 있었다.
 * 문자열로도 test case의 정답을 도출해냈는데 왜 틀렸는 지 모르겠는 문제이다.. 맞왜틀.
 * 다익스트라 pq 처리 과정에서 부등호 때문에 틀렸었다.
 * 
 * visited 배열을 지우고, endNum에 도달했을 때에 while 문을 탈출하면 시간 초과가 해결된다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

import java.io.*;
//백준 <다익스트라> '최소비용 구하기 2'
public class BOJ11779 {
	static int N,M,startNum,endNum;
	static long [] distance;
	static int [] parent;
	static List<Bus> [] busList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		busList = new ArrayList[N+1];
		distance = new long[N+1];
		parent = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			busList[i] = new ArrayList<>();
			distance[i] = Long.MAX_VALUE;
			
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			busList[start].add(new Bus(end,cost));
		}
		st = new StringTokenizer(br.readLine());
		startNum = Integer.parseInt(st.nextToken());
		endNum = Integer.parseInt(st.nextToken());
		
		dijkstra(startNum);
		
		Stack<Integer> stack = searchPath();
		
		System.out.println(distance[endNum]);
		System.out.println(stack.size());
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb.substring(0, sb.length()-1));
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		
		pq.offer(new Bus(start,0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Bus temp = pq.poll();
			int cur = temp.end;
			
			if(cur == endNum)
				break;
			
			for(Bus bus : busList[cur]) {
				if(distance[bus.end] > distance[cur] + bus.cost) {
					distance[bus.end] = distance[cur] + bus.cost;
					pq.offer(new Bus(bus.end, distance[bus.end]));
					
					parent[bus.end] = cur;
				}
			}		
		}
	}
	public static Stack<Integer> searchPath(){
		Stack<Integer> stack = new Stack<>();
		int cur = endNum;
		
		while(cur != startNum) {
			stack.push(cur);
			
			cur = parent[cur];
		}
		stack.push(cur);
		
		return stack;
	}
	
	static class Bus implements Comparable<Bus>{
		int end;
		long cost;
		
		Bus(int end, long cost){
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Bus o) {
			return Long.compare(this.cost, o.cost);
		}
	}
}