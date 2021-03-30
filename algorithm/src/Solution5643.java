/**
 * @author choi
 * @date Nov 4, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
 * @mem 35,984kb
 * @time 520ms
 * @caution
 * [고려사항]
 * 백준의 키 순서 문제와 똑같다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <SW역량테스트> '키 순서'
public class Solution5643 {
	static int N, M;
	static int[][] map;
	static int[] count;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

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

			System.out.println("#" + t + " " + answer);
		}
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