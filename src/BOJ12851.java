/**
 * @author choi
 * @date Sep 18, 2020
 * @see https://www.acmicpc.net/problem/12851
 * @mem 20,484kb
 * @time 240ms
 * @caution
 * [고려사항]
 * 최소 시간 이상은 볼 필요도 없다는 것을 알고있으면 된다.
 * N이 K보다 크다면 N-K만큼 시간이 지나면 K도착하는 방법밖에 없으므로
 * N-K와 1을 출력한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <BFS> '숨바꼭질 2'
public class BOJ12851 {
    static int K;
    static int N;
    static int[] time = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }

        bfs();

        System.out.println(minTime);
        System.out.println(count);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            // now 방문 시간이 최소 시간보다 크면 뒤는 더 볼 필요 없음
            if (minTime < time[now]) return;

            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)
                    next = now + 1;
                else if (i == 1)
                    next = now - 1;
                else
                    next = now * 2;

                if (!isIn(next)) continue;

                if (next == K) {
                    minTime = time[now];
                    count++;
                }

                // 이미 방문한 곳이어도 경우의 수 카운팅을 위해 큐에 넣어줌
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    q.offer(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }

    public static boolean isIn(int x) {
        return x >= 1 && x <= K + 1;
    }
}