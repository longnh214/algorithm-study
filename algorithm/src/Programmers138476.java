/**
 * @author nakhoon
 * @date 1/12/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/138476
 * @mem
 * @time
 * @caution
 * [고려사항]
 * map의 getOrDefault 함수와 우선순위 큐를 통해 문제를 해결하였다.
 * 배열로 선언하기에는 메모리가 너무 커질 수 있다는 고려사항이 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//프로그래머스 <연습문제> '귤 고르기'
public class Programmers138476 {
    public static void main(String[] args) {
        int k = 6;
        int [] targerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k ,targerine));
    }

    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        //내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //개수만 뽑아서 우선순위 큐에 넣는다.
        for(int key : map.keySet()){
            pq.add(map.get(key));
        }

        int count = 0;
        int sum = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();

            if(sum <= k){
                sum += cur;
                count++;
            }

            //넘었을 경우에는 더 종류를 넣을 수 없으므로 break.
            //위에서 값이 같아졌다면 break.
            if(sum >= k){
                break;
            }
        }

        return count;
    }
}
