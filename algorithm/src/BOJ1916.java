/**
 * @author choi
 * @date Sep 6, 2020
 * @see https://www.acmicpc.net/problem/1916
 * @mem 47,252kb
 * @time 376ms
 * @caution
 * [고려사항]
 * 다익스트라 알고리즘을 이용해서 문제를 풀었다.
 * distance 배열에 계속 최소 비용을 갱신하였다.
 * (PriorityQueue 이용) 
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <다익스트라> '최소 비용 구하기'
public class BOJ1916 {
    static int N,M,startNum,endNum;
    static long totalCost;
    static long [] distance;
    static List<Bus> [] busList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        busList = new ArrayList[N+1];
        distance = new long[N+1];

        for(int i=1;i<=N;i++) {
            busList[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busList[start].add(new Bus(end,cost));
        }
        st = new StringTokenizer(br.readLine());
        startNum = Integer.parseInt(st.nextToken());
        endNum = Integer.parseInt(st.nextToken());

        dijkstra(startNum);

        System.out.println(distance[endNum]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();

        boolean [] visited = new boolean[N+1];

        pq.offer(new Bus(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Bus temp = pq.poll();
            int cur = temp.end;
            if(!visited[cur])
                visited[cur] = true;

            for(Bus bus : busList[cur]) {
                if(distance[bus.end] > distance[cur] + bus.cost) {
                    distance[bus.end] = distance[cur] + bus.cost;
                    pq.offer(new Bus(bus.end, distance[bus.end]));
                }
            }

        }
    }

    static class Bus implements Comparable<Bus>{
        int end;
        long cost;
        Bus(int end, long cost){
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Bus o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}