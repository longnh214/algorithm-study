/**
 * @author nakhoon
 * @date Sep 4, 2021
 * @see https://www.acmicpc.net/problem/2157
 * @mem 61,724kb
 * @time 548ms
 * @caution
 * [고려사항]
 * dp로 풀려고 했지만... 시간초과가 나서 결국 bfs+dp로 풀었던 문제이다. 인접 배열로는 모든 값을 탐색해가는 과정에서 시간 초과가 났었던거같다.
 * dp[걸음수][좌표] = 점수의 방식으로 dp 배열에 메모이제이션을 했었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '여행'
public class BOJ2157 {
	static int N,M,K,result;
	static int [][] dp;
	static List<Info> [] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[N+1][N+1];
		adjList = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to  = Integer.parseInt(st.nextToken());
			int score  = Integer.parseInt(st.nextToken());
			
			if(from < to)
				adjList[from].add(new Info(to, score));
		}
		
		bfs();
		System.out.println(result);
	}
	
	public static void bfs() {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(1,1,0));
		
		while(!q.isEmpty()) {
			Info curInfo = q.poll();
			
			if(curInfo.score < dp[curInfo.cnt][curInfo.point])
				continue;
			
			if(curInfo.point == N && curInfo.cnt <= M) {
				result = Math.max(result, curInfo.score);
				continue;
			}
			
			for(Info nextInfo : adjList[curInfo.point]) {
				if(nextInfo.point != N && curInfo.cnt + 1 == M) {
					continue;
				}
				
				if(curInfo.score + nextInfo.score > dp[curInfo.cnt + 1][nextInfo.point]) {
					dp[curInfo.cnt + 1][nextInfo.point] = curInfo.score + nextInfo.score;
					q.offer(new Info(nextInfo.point, curInfo.cnt +1,curInfo.score + nextInfo.score));
				}
			}
		}
	}

	static class Info{
		int point;
		int cnt;
		int score;
		
		Info(int point, int cnt, int score){
			this.point = point;
			this.cnt = cnt;
			this.score = score;
		}
		
		Info(int point, int score){
			this.point = point;
			this.score = score;
		}
	}
}