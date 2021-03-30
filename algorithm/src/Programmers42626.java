import java.util.*;
//프로그래머스 코딩테스트 연습 <힙(Heap)> - '더 맵게' 문제
public class Programmers42626 {
    public static int solution(int[] scoville, int K) {
        int answer = -1;
        int num1, num2;
        int temp;
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++)
            pq.offer(scoville[i]);

        while(pq.size() > 1){
            if(pq.peek() >= K) {
                answer = count;
                break;
            }
            num1 = pq.poll();
            num2 = pq.poll();
            temp = num1 + (num2 * 2);
            pq.offer(temp);
            count++;
        }
        //마지막까지 scoville 지수를 구했을 때 K 값을 넘지 못한다면 -1
        if(pq.poll() >= K)
            answer = count;

        return answer;
    }

    public static void main(String[] args) {
        int [] scoville = {1,2,3,9,10,12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
