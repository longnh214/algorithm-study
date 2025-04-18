/**
 * @author nakhoonchoi
 * @date 2025/04/18
 * @see https://boj.ma/2098
 * @mem 224,628kb
 * @time 1,640ms
 * @caution
 * [고려사항]
 * dp와 비트마스킹을 이용해 풀 수 있는 문제였다.
 * 최대값을 Integer.MAX_VALUE로 설정하면 틀릴 수 있었다. 최대값을 정할 때에 실제로 나올 수 있는 최대값으로 설정해야겠다.
 * 기존에 DP+DFS 기반으로 풀이를 제출했었으나 몇 년 전에 재채점이 되어 실패 처리 되어 다시 풀어보았다.
 *
 * 우선 외판원 순회란 TSP(Traveling-Salesman-Problem)이라고 하는 유명한 문제를 푸는 DP 기법이라고 한다.
 * 여기서 문제는 외판원이 모든 도시를 순회해서 돌아올 수 있는 가장 최적의 비용을 구하는 문제이다.
 * (하지만 여기에서 한 번 갔던 도시를 다시 갈 수는 없다.)
 * 그리고 다익스트라와 다른 점은 i->j 방향으로 가는 비용과 j->i 방향으로 이동하는 비용이 다르다는 점이다.
 *
 * 일단 이 문제는 사이클이 존재하기 때문에 출발지를 어디에서 해도 상관이 없으므로 0부터 시작한다고 가정하고 진행했다.
 * 브루트포스로 접근할 수 있지만 도시가 N개인 경우 최악의 경우 (N-1)!의 경우의 수만큼 탐방해야하기 때문에
 * 도시가 16개라면 15!이 1,307,674,368,000로 1조가 넘으니 브루트포스로 수행할 수는 없었다.
 *
 * 그래서 이 문제를 다르게 접근해야하는 데 DP(Dynamic Programming)으로 접근해야한다.
 * DP도 똑같이 완전 탐색이지만 이전에 진행했던 경로를 기억해놓음으로서 계산 횟수를 줄이는 기법이다.
 *
 * 먼저 arr[N][N] 2차원 배열에 각 i->j로 이동할 때 드는 비용을 기입했다.
 * 그리고 DP에 대한 Map은 2차원(?) Map으로 Map<도시의 index, Map<현재 접근한 도시의 상태 BitSet int형, 비용>>으로 선언했다.
 * 값으로 비용 의미는 0번부터 시작해서 BitSet의 상태로 i에 접근했을 때의 총 비용을 나타내는 것이다.
 *
 * 대부분 비트마스킹+DP로 외판원 순회 문제를 해결하는 분들이 많지만
 * 비트마스킹 문제를 풀 때 BitSet을 이용해서 푸는 편이라 BitSet을 이용했다.
 *
 * 위와 같이 dpMap을 선언했고 초기 BitSet은 0번 도시를 제외한 모든 비트를 1로 셋해주었다.
 * 예를 들어 도시가 5개일 경우에는 01111, 8개 일 경우에는 0111111로 BitSet이 내부로 세팅 될 것이다.
 *
 * tsp(int current, BitSet remaining) 메소드에 대해서 설명하면
 * current는 현재 위치, remaining은 현재 BitSet의 현황, 모든 비트가 0일 때까지 탐색해야한다는 것을 의미한다.
 *
 * 이미 dpMap의 current 대상 Map 안에 현재 remaining의 값이 존재한다면 값을 재활용하도록 구현하고
 * 현재 current 기준으로 N까지 순회해서 길이 없거나, 이미 방문된 곳이라면 continue하고
 * 갈 수 있는 next 도시라면 도시에 대한 비트를 1->0으로 바꾸면서 갱신된 비트와 next 기준으로
 * tsp(next, 갱신된 BitSet)을 수행한 뒤에 추론된 비용으로 최소 비용을 계속 갱신해주었다.
 * 그리고 tsp 메소드 안에서 나온 현재 도시와 방문 기준 최소 비용을 Map에 기록해주었다.
 *
 * BitSet을 이용하는 것보다 비트 연산을 이용하는 것이 훨씬 빠르다는 것을 알 수 있었다.
 * tsp 메소드를 재귀적으로 호출해서 문제를 해결했고, 해당 문제를 계속 풀어봐야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <외판원 순회> '외판원 순회'

public class BOJ2098 {
	static int [][] arr;
	static Map<Integer, Map<BitSet, Integer>> dpMap = new HashMap<>();
	static int N;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BitSet initial = new BitSet(N);
		for(int i=1;i<N;i++){
			initial.set(i);
		}

		int result = tsp(0, initial);
		System.out.println(result == INF ? -1 : result);
	}

	public static int tsp(int current, BitSet remaining) {
		if (remaining.isEmpty()) {
			return arr[current][0] == 0 ? INF : arr[current][0];  // 돌아갈 수 없으면 INF
		}

		dpMap.putIfAbsent(current, new HashMap<>());
		if (dpMap.get(current).containsKey(remaining)) {
			return dpMap.get(current).get(remaining);
		}

		int minCost = INF;

		for (int next = 1; next < N; next++) {
			if (!remaining.get(next) || arr[current][next] == 0) continue;

			BitSet nextRemaining = (BitSet) remaining.clone();
			nextRemaining.clear(next);

			int cost = tsp(next, nextRemaining);
			if (cost != INF) {
				minCost = Math.min(minCost, arr[current][next] + cost);
			}
		}

		dpMap.get(current).put(remaining, minCost);
		return minCost;
	}
}