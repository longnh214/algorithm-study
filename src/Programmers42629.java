import java.util.*;
//프로그래머스 코딩테스트 연습 <힙(Heap)> - '라면공장' 문제
public class Programmers42629 {
    public static void main(String[] args) {
        int stock = 4;
        int [] dates = {4,10,20};
        int [] supplies = {20,5,10};
        int k = 30;
        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int supplyIndex = 0;


        for(int i=0;i<k;++i){
            //dates 배열에 속한 날짜일 때 우선순위 큐에 해당 인덱스 밀가루 값을 넣어준다.
            if(supplyIndex < dates.length && i == dates[supplyIndex])
                pq.offer(supplies[supplyIndex++]);
            //밀가루 재고가 모자르다면 현재 우선순위 큐 안에 있는 밀가루 값 중 최대값을 꺼내 재고에 더한다.
            stock--;
            if(stock == -1){
                stock += pq.poll();
                answer++; //count 계산
            }
        }
        return answer;
    }
}