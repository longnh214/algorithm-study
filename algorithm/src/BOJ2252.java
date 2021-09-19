/**
 * @author nakhoon
 * @date Sep 19, 2021
 * @see https://www.acmicpc.net/problem/2252
 * @mem 50,592kb
 * @time 468ms
 * @caution
 * [고려사항]
 * 위상 정렬을 처음 적용해본 문제이다. dfs로 푸는 방법과 indegree+우선순위큐를 이용해 푸는 방법이 있지만, 우선순위큐 방법으로 먼저 연습할 것이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <위상 정렬> '줄 세우기'
public class BOJ2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//키 순서가 나보다 확실하게 작은 사람의 수(내 순서의 앞의 수)를 저장하는 배열
		int [] indegree = new int[N+1];
		boolean [] visited = new boolean[N+1];
		List<Integer> [] adjList = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			adjList[first].add(second);
			indegree[second]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1;i<=N;i++) {
			if(indegree[i] == 0) {
				pq.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int curOrder = pq.poll();
			sb.append(curOrder + " ");
			for(int next : adjList[curOrder]){
				indegree[next]--;
				if(indegree[next] == 0)
					pq.offer(next);
			}
		}		
		System.out.println(sb.substring(0, sb.length()-1));
	}
}