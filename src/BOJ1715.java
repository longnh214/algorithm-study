/**
 * @author choi
 * @date Jan 5, 2021
 * @see https://www.acmicpc.net/problem/1715
 * @mem 24,856kb
 * @time 364ms
 * @caution
 * [고려사항]
 * 아무래도 JAVA는 우선순위큐가 이미 구현되어있어서 쉽지 않았나 생각한다.
 * 예외 case는 N이 1일 때 비교 횟수가 전혀 없으므로 0을 출력해야 한다는 것!
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위큐> '카드 정렬하기'
public class BOJ1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        if(N == 1) {
            System.out.println(answer);
        }else {
            while(true) {
                int temp = pq.poll();
                temp += pq.poll();
                answer += temp;
                if(pq.isEmpty()) break;
                pq.offer(temp);
            }
            System.out.println(answer);
        }
    }
}