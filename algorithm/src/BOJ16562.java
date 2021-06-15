/**
 * @author nakhoon
 * @date Jun 15, 2021
 * @see https://www.acmicpc.net/problem/16562
 * @mem 17,184kb
 * @time 180ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

// 백준 <유니온파인드> '친구비'
public class BOJ16562 {
	static int[] team;
	static Pair[] root;
	static int[] cost;
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		team = new int[N + 1];
		root = new Pair[N + 1];
		cost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			root[i] = new Pair(i, 0);
			team[i] = i;
		}
		

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			union(v, w);
		}

		for (int i = 1; i <= N; i++) {
			int r = find(i);
			root[r].index = r;
			if (root[r].cost == 0)
				root[r].cost = cost[i];
			else
				root[r].cost = Math.min(root[r].cost, cost[i]);
		}

		int total = 0;
		for (int i = 1; i <= N; i++) {
			if (root[i].cost != 0)
				total += root[i].cost;
		}
		if (K >= total)
			System.out.println(total);
		else
			System.out.println("Oh no");
	}

	public static int find(int n) {
		if (team[n] == n)
			return n;
		return team[n] = find(team[n]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return;
		team[y] = x;
	}

	static class Pair {
		int index;
		int cost;

		Pair(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
}