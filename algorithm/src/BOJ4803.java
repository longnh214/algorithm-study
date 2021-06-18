/**
 * @author nakhoon
 * @date Jun 18, 2021
 * @see https://www.acmicpc.net/problem/4803
 * @mem 53,028kb
 * @time 368ms
 * @caution
 * [고려사항]
 * 노드의 rank, 우선순위를 생각해야하는 문제였다.
 * parent[x] = y 에 대해서 parent[]값을 x,y중 작은 값으로 대체해야 스택 오버플로우가 안 난다.
 * [0, 1, 1, 1, 1, 1, 1] -> 정답 / [0, 6, 6, 6, 6, 6, 6] -> 런타임 에러
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <union-find> '트리'
public class BOJ4803 {
	static int [] parent;
	static int N,M;
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			
			parent = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				parent[i] = i;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				union(v,w);
			}
			
			set = new HashSet<>();
			
			for(int i=1;i<=N;i++) {
				int pi = find(i);
				if(pi > 0)
					set.add(pi);
			}
			
			StringBuilder sb = new StringBuilder();
			
			int size = set.size();
			
			if(set.isEmpty()) {
				sb.append("No trees.");
			}else if(size == 1) {
				sb.append("There is one tree.");
			}else {
				sb.append("A forest of ").append(size).append(" trees.");
			}
			
			System.out.println("Case " + testCase++ + ": " + sb);
		}

	}
	public static int find(int n) {
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			parent[y] = x;
			parent[x] = 0;
		}else if(x > y){
			parent[x] = y;
		}else {
			parent[y] = x;
		}
	}
}