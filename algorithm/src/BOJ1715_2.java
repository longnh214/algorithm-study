/**
 * @author nakhoonchoi
 * @date 2024/08/30
 * @see https://www.acmicpc.net/problem/1715
 * @mem 24,596kb
 * @time 300ms
 * @caution
 * [고려사항]
 * N이 1일 때에는 비교를 할 필요가 없으므로 0을 return해야하고,
 * 2이상일 때는 두 수를 우선순위 큐에서 뽑아서 합해서 답으로 저장하고,
 * 큐에 숫자가 없다면 break, 있다면 합을 우선순위 큐에 넣고 다시 진행한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <우선순위큐> '카드 정렬하기'

public class BOJ1715_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }

        int sum = 0;
        if(N == 1){
            System.out.println(sum);
        }else {
            int data1, data2;
            while (true) {
                data1 = pq.poll();
                data2 = pq.poll();
                sum += (data1 + data2);
                if(pq.isEmpty()) break;
                pq.offer(data1 + data2);
            }
            System.out.println(sum);
        }
    }
}