/**
 * @author nakhoonchoi
 * @date 2024/09/03
 * @see https://www.acmicpc.net/problem/2696
 * @mem 16,020kb
 * @time 140ms
 * @caution
 * [고려사항]
 * maxHeap과 minHeap을 하나씩 두어, (1,2,3), (4,5)와 같이 힙을 두어,
 * maxHeap의 peek() 위치에 중간값을 둔다고 생각하고 문제를 풀면 된다.
 * minHeap에 값이 있을 때, maxHeap의 peek() 값과 minHeap의 peek() 값을 비교해서
 * minHeap의 값이 더 크면, 위치를 서로 바꿔준다.
 * maxHeap부터 minHeap까지 자동으로 정렬이 진행된다.
 * i % 2 == 0일 때마다 maxHeap에서 값을 peek한 값을 출력하면 된다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <우선순위큐> '중앙값 구하기'

public class BOJ2696 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2) * -1;
                }
            });

            sb.append(((N + 1) / 2) + "\n");

            for(int i=0;i<N;i++){
                if(i%10 == 0){
                    st = new StringTokenizer(br.readLine());
                }
                int num = Integer.parseInt(st.nextToken());
                if(maxHeap.size() == minHeap.size()){
                    maxHeap.offer(num);
                }else{
                    minHeap.offer(num);
                }

                if(!minHeap.isEmpty()){
                    //minHeap에는 중간값보다 높은 숫자만 가야한다.
                    //반대로 maxHeap에는 중간값보다 낮은 숫자가 있어야한다.
                    if(maxHeap.peek() > minHeap.peek()){
                        int t1 = maxHeap.poll();
                        int t2 = minHeap.poll();

                        maxHeap.offer(t2);
                        minHeap.offer(t1);
                    }
                }

                if(i % 2 == 0){
                    if((i+2) % 20 == 0 || i == N-1){
                        sb.append(maxHeap.peek() + "\n");
                    }else{
                        sb.append(maxHeap.peek() + " ");
                    }
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}