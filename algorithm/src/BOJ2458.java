/**
 * @author choi
 * @date Nov 4, 2020
 * @see https://www.acmicpc.net/problem/2458
 * @mem 35,984kb
 * @time 520ms
 * @caution
 * [고려사항]
 * bfs로 풀었다가 메모리 초과가 나서 dfs로 바꿔서 풀었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS> '키 순서'
public class BOJ2458 {
	static int N, M;
	static int[][] map;
	static int[] count;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		count = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			// 매 기준마다 방문표시 초기화
			Arrays.fill(visited, false);
			dfs(i, i);
		}
		for (int i = 1; i <= N; i++) {
			if (count[i] == N - 1)
				answer++;
		}

		System.out.println(answer);
	}

	public static void dfs(int standard, int target) {
		if (standard != target) { // 자기 자신 제외
			count[standard]++;
			count[target]++;
		}
		visited[target] = true;
		for (int i = 1; i <= N; i++) {
			// 아직 방문하지 않으면서 now가 i보다 큰 경우
			if (!visited[i] && map[target][i] == 1) {
				dfs(standard, i);
			}
		}
	}
}