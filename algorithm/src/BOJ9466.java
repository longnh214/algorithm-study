/**
 * @author nakhoon
 * @date Jul 18, 2021
 * @see https://www.acmicpc.net/problem/9466
 * @mem 301,596kb
 * @time 1,168ms
 * @caution
 * [고려사항]
 * dfs 탐색의 끝은 사이클에 포함되는 원소라는 것이 핵심인 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS> '텀 프로젝트'
public class BOJ9466 {
	static int [] team;
	static boolean [] visited;
	static boolean [] finished;
	static int N,count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			team = new int[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			
			for(int i=1;i<=N;i++) {
				team[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<=N;i++) {
				dfs(i);
			}
			
			System.out.println(N - count);
		}
	}
	
	public static void dfs(int cur) {
		//기저조건
		if(visited[cur])
			return;
		
		visited[cur] = true;
		int next = team[cur];
		
		//한번도 방문하지 않았던 곳이라면
		if(!visited[next])
			dfs(next);
		//한번 방문 했지만 끝나지 않았다면, 그 원소는 사이클에 포함되는 원소일 것이다.
		else{
			if(!finished[next]) {
				count++;
				int temp = next;
				while(temp != cur) {
					count++;
					temp = team[temp];
				}
			}
		}
		//dfs에 거친 원소들은 전부 다시 탐색할 필요 없다.
		finished[cur] = true;
	}
}