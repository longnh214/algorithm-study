/**
 * @author nakhoonchoi
 * @date 2024/11/07
 * @see https://softeer.ai/practice/7697
 * @caution
 * [고려사항]
 * 놓친 부분이 있었다.
 * N의 제한이 최대 50만이고, 미생물 크기도 최대가 50만이었다...
 * 고로 범위는 long 형으로 표현해야한다는 것을 알 수 있었다...
 * int형에서 long형으로 고쳤더니 맞았다.
 * 인접한 미생물을 찾을 때, 앞과 뒤가 합쳐질 미생물인지 전부 미리 파악한 후에 합쳤어야하는 점이 주의할 점이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//소프티어 <한양대 HCPC 2023> 'Phi Squared'

public class Softeer7697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Node> todayDeque = new ArrayDeque<>();
        Deque<Node> nextDayDeque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            long size = Long.parseLong(st.nextToken());
            todayDeque.offer(new Node(i, size));
        }

        while(todayDeque.size() + nextDayDeque.size() > 1){
            Node cur = todayDeque.pollFirst();
            Node lastNode = null;
            Node firstNode = null;

            if (!nextDayDeque.isEmpty() && nextDayDeque.peekLast().size <= cur.size) {
                lastNode = nextDayDeque.pollLast();
            }

            if (!todayDeque.isEmpty() && todayDeque.peekFirst().size <= cur.size) {
                firstNode = todayDeque.pollFirst();
            }

            long size = cur.size;

            if(lastNode != null){
                size += lastNode.size;
            }

            if(firstNode != null){
                size += firstNode.size;
            }

            nextDayDeque.offer(new Node(cur.index, size));

            if(todayDeque.isEmpty()) {
                todayDeque = nextDayDeque;
                nextDayDeque = new ArrayDeque<>();
            }
        }

        Node answer = todayDeque.poll();

        System.out.println(answer.size);
        System.out.println(answer.index);
    }

    static class Node{
        int index;
        long size;

        Node(int index, long size){
            this.index = index;
            this.size = size;
        }
    }
}