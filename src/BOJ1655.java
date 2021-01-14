/**
 * @author choi
 * @date Jan 15, 2021
 * @see https://www.acmicpc.net/problem/1655
 * @mem 35,392kb
 * @time 416ms
 * @caution
 * [고려사항]
 * 우선순위큐를 하나만 써서 해결하려하니 메모리 초과가 났다.
 * 정렬을 많이 해주어서 메모리 초과인 것 같다.
 * 블로그를 참고하여 최소 힙, 최대 힙을 표현하여 항상 최대 힙의 peek 값을 출력하도록 하였더니 맞출 수 있었다.
 * (최대 힙의 peek 값이 최소 힙의 peek 값보다 크면 값을 바꿔주었다.)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위큐> '가운데를 말해요'
public class BOJ1655 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()) {
                maxHeap.offer(num);

                if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(minHeap.poll());
                }
            }else {
                minHeap.offer(num);

                if(maxHeap.peek() > minHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(minHeap.poll());
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}