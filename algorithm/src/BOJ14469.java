/**
 * @author nakhoonchoi
 * @date 2024/11/14
 * @see https://boj.ma/14469
 * @mem 11,700kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 우선순위큐를 통해 문제를 해결하였다.
 * 11000번 문제 회의실 배정과 비슷한 느낌이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <그리디 알고리즘> '소가 길을 건너간 이유 3'

public class BOJ14469 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] cow = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cow, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int lastStartTime;

        pq.offer(cow[0][0] + cow[0][1]);

        for(int i=1;i<N;i++) {
            if(cow[i][0] >= pq.peek()) {
                pq.poll();
                lastStartTime = cow[i][0];
                pq.offer(lastStartTime + cow[i][1]);
            }else {
                lastStartTime = pq.poll();
                pq.offer(lastStartTime + cow[i][1]);
            }
        }

        System.out.println(pq.peek());
    }
}