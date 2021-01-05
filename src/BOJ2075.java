/**
 * @author choi
 * @date Jan 5, 2021
 * @see https://www.acmicpc.net/problem/2075
 * @mem 334,192kb
 * @time 880ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위큐> 'N번째 큰 수'
public class BOJ2075 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2) * -1;
            }
        });
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        int answer = -1;
        for(int i=0;i<N;i++) {
            answer = pq.poll();
        }

        System.out.println(answer);
    }
}