/**
 * @author choi
 * @date Jan 5, 2021
 * @see https://www.acmicpc.net/problem/11000
 * @mem 72,800kb
 * @time 572ms
 * @caution
 * [고려사항]
 * 수업의 시작 시간을 기준으로 오름차순 정렬해야 해결할 수 있는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위큐> '강의실 배정'
public class BOJ11000 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] course = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            course[i][0] = Integer.parseInt(st.nextToken());
            course[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(course, new Comparator<int []>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }

        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(course[0][1]);

        for(int i=1;i<N;i++) {
            if(course[i][0] < pq.peek()) {
                pq.offer(course[i][1]);
            }else {
                pq.poll();
                pq.offer(course[i][1]);
            }
        }

        System.out.println(pq.size());
    }
}