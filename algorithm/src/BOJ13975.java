/**
 * @author choi
 * @date Jan 8, 2021
 * @see https://www.acmicpc.net/problem/13975
 * @mem 323,528kb
 * @time 3100ms
 * @caution
 * [고려사항]
 * 백준 알고리즘의 DP 문제 <파일 합치기> 문제와는 다르게 연속적이지 않아도 되어서
 * 우선순위 큐를 이용해 먼저 나오는 두 묶음 씩 더한 값을 비용으로 생각하면 풀 수 있었다.
 * int 타입이면 범위를 벗어나므로 모든 타입을 long으로 선언해주었을 때 맞을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위큐> '파일 합치기 3'
public class BOJ13975 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int t=1;t<=T;t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long answer = 0;
            for(int i=0;i<N;i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            for(int i=0;i<N-1;i++) {
                long first = pq.poll();
                long second = pq.poll();
                answer += (first + second);
                pq.offer(first + second);
            }
            pq.clear();
            System.out.println(answer);
        }
    }
}