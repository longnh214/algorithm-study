/**
 * @author nakhoonchoi
 * @date 2024/08/31
 * @see https://www.acmicpc.net/problem/19598
 * @mem 54,432kb
 * @time 644ms
 * @caution
 * [고려사항]
 * 회의실을 시작 시간에 따라 정렬하고, 끝 시간을 우선순위 큐에 저장해놓은 뒤에
 * 큐에 저장된 끝 시간과 현재 회의실 수업 시작 시간을 비교해서 기존 큐에서 빼고 넣을 지,
 * 빼지 않고 넣기만 할 지 고려해서 반복문을 돌린 뒤 우선순위 큐의 크기를 출력하면 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <우선순위큐> '최소 회의실 갯수'

public class BOJ19598 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] talkingRoom = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            talkingRoom[i][0] = Integer.parseInt(st.nextToken());
            talkingRoom[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(talkingRoom, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return Integer.compare(o1[1], o2[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(talkingRoom[0][1]);
        for(int i=1;i<N;i++){
            int curPeek = pq.peek();
            if(talkingRoom[i][0] >= curPeek){
                pq.poll();
            }
            pq.offer(talkingRoom[i][1]);
        }

        System.out.println(pq.size());
    }
}