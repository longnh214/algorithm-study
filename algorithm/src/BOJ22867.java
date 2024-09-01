/**
 * @author nakhoonchoi
 * @date 2024/09/01
 * @see https://www.acmicpc.net/problem/22867
 * @mem 131,684kb
 * @time 1,000ms
 * @caution
 * [고려사항]
 * 백준의 '최소 회의실 갯수'와 비슷한 문제로,
 * 시간을 long 형으로 변환하는 과정이 들어간 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <우선순위큐> '종점'

public class BOJ22867 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long [][] busTime = new long[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            busTime[i][0] = timeToLong(st.nextToken());
            busTime[i][1] = timeToLong(st.nextToken());
        }

        Arrays.sort(busTime, ((o1, o2) -> {
            if(o1[0] == o2[0]){
                return Long.compare(o1[1], o2[1]);
            }else{
                return Long.compare(o1[0], o2[0]);
            }
        }));

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(busTime[0][1]);

        for(int i=1;i<N;i++){
            long curPeek = pq.peek();
            if(busTime[i][0] >= curPeek){
                pq.poll();
            }
            pq.offer(busTime[i][1]);
        }
        System.out.println(pq.size());
    }

    public static long timeToLong(String time){
        long value = 0L;
        String [] splitValue = time.split(":");
        value += (Long.parseLong(splitValue[0]) * 60 * 60 * 1000);
        value += (Long.parseLong(splitValue[1]) * 60 * 1000);
        value += (Float.parseFloat(splitValue[2]) * 1000);

        return value;
    }
}