/**
 * @author nakhoon
 * @date Sep 28, 2021
 * @see https://www.acmicpc.net/problem/13023
 * @mem 16,804kb
 * @time 236ms
 * @caution
 * [고려사항]
 * 문제를 너무 어렵게 생각해서 해결할 수 없었던 문제이다. dfs 함수의 depth가 4인 지 아닌 지 판별하면 되는 문제였는데
 * 몇 명의 친구에 접근(?)했는 가 잘못 생각했었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS> 'ABCDE'
public class BOJ13023 {
	static List<Integer> [] adjList;
	static boolean [] visited;
	static int N;
	static boolean isFriend;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(M < 4) {
			System.out.println(0);
			return;
		}
		
		adjList = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			adjList[first].add(second);
			adjList[second].add(first);
		}
		
		for(int i=0;i<N;i++) {
			visited[i] = true;
			dfs(i,0);
			visited[i] = false;
			if(isFriend) {
				System.out.println(1);
				return;
			}
			
		}
		System.out.println(0);
	}
	
	public static void dfs(int n, int depth) {
		if(depth == 4) {
			isFriend = true;
			return;
		}
		
		for(int next : adjList[n]) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, depth+1);
				visited[next] = false;
			}
		}
	}
}