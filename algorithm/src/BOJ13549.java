/**
 * @author choi
 * @date Sep 18, 2020
 * @see https://www.acmicpc.net/problem/13549
 * @mem 17,892kb
 * @time 124ms
 * @caution
 * [고려사항]
 * PriorityQueue를 사용해서 풀 수도 있지만
 * if의 순서를 *2, -1, +1순서로 하면 가장 최소의 값으로 도달할 수 있음을 알 수 있었다.
 * (문제 있음.)
 * Deque를 이용해 우선순위가 높은 순간이동은 Deque의 앞에 넣어주고,
 * 낮은 걸음은 Deque의 뒤에 넣어주어 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> - '숨바꼭질 3'
public class BOJ13549 {
    static int K;
    static int N;
    static int [] arr = new int[100003];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //arr = new int[K+3];
        Arrays.fill(arr, -1);

        bfs();

        System.out.println(arr[K]);
    }
    public static boolean isIn(int x) {
        return x>=1 && x<K+1;
    }


    public static void bfs() {
        Deque<Integer> q = new LinkedList<>();
        arr[N] = 0;
        q.offer(N);

        while(!q.isEmpty()) {
            N = q.poll();
            if(N==K) break;
            if(N*2 <= 100000 && arr[N*2] == -1) {
                arr[N*2] = arr[N];
                q.offerFirst(N*2);
            }
            if(N-1 >= 0 && arr[N-1] == -1) {
                arr[N-1] = arr[N] + 1;
                q.offerLast(N-1);
            }
            if(N+1 <= 100000 && arr[N+1] == -1) {
                arr[N+1] = arr[N] + 1;
                q.offerLast(N+1);
            }
        }
    }
}