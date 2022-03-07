/**
 * @author nakhoon
 * @date 2022, 3월 5일
 * @see https://www.acmicpc.net/problem/23843
 * @mem 13,476kb
 * @time 140ms
 * @caution
 * [고려사항]
 * 먼저 들어온 충전에 대해 내림차순으로 정렬하고, 최소 우선순위 큐를 사용하였다.
 * 콘센트의 갯수가 찼다면 현재 시간 + 충전 시간을 큐에 넣어주었다.
 * 아니라면 현재 충전 시간을 큐에 넣어주었다.
 * 그리고 마지막에 큐에 있는 가장 최대값을 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//백준 <우선순위 큐> '콘센트'
public class BOJ23843 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer [] electric = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            electric[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(electric, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            if(pq.size() < M){
                pq.offer(electric[i]);
            }else{
                int outcome = pq.poll();
                pq.offer(outcome + electric[i]);
            }
        }
        int answer = -1;
        while(!pq.isEmpty()){
            answer = pq.poll();
        }
        System.out.println(answer);
    }
}