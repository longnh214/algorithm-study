/**
 * @author nakhoonchoi
 * @date 2023/12/16
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/138477
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 우선순위 큐와 큐의 크기를 제한해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '명예의 전당(1)'
public class Programmers138477 {
    public static void main(String[] args) {
        int k = 3;
        int [] score = {10,100,20,150,1,100,200};

        System.out.println(Arrays.toString(solution(k, score)));
    }

    public static int[] solution(int k, int[] score) {
        List<Integer> answerList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<score.length;i++){
            pq.offer(score[i]);

            if(pq.size() > k){
                pq.poll();
            }

            answerList.add(pq.peek());
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
