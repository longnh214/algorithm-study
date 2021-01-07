/**
 * @author choi
 * @date Jan 8, 2021
 * @see https://www.acmicpc.net/problem/13975
 * @mem 323,528kb
 * @time 3100ms
 * @caution
 * [고려사항]
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