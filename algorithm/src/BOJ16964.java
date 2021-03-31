/**
 * @author nakhoon
 * @date Apr 1, 2021
 * @see https://www.acmicpc.net/problem/16964
 * @mem 67,864kb
 * @time 472ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS> 'DFS 스페셜 저지'
public class BOJ16964 {
	static List<Integer> [] adjList;
	static int N,visitCount;
	static int [] arr;
	static boolean flag;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		adjList = new ArrayList[N+1];
		arr = new int[N];
		visited = new boolean[N+1];
		flag = true;
		//1번째는 사실 1로 고정이므로 2번째 부터 탐색하면 된다.
		visitCount = 1;
		
		for(int i=1;i<=N;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(arr[0] != 1) {
			System.out.println("0");
			return;
		}
		
		dfs(1);
		
		if(flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static void dfs(int i) {
		if(visited[i]) return;
		visited[i] = true;
		
		HashSet<Integer> set = new HashSet<>();
		for(int next : adjList[i]) {
			if(visited[next]) continue;
			set.add(next);
		}
		
		if(set.size() == 0) return;
		
		if(set.contains(arr[visitCount])) {
			dfs(arr[visitCount++]);
		} else {
			flag = false;
		}
	}
}