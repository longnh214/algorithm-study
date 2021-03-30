import java.util.*;
//프로그래머스 코딩테스트 연습 <스택/큐> - '주식가격' 문제
//스택/큐를 이용해서 풀이
public class Programmers42584_2 {
    public static int [] solution(int [] prices){
        int [] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();

        stack.push(new Stock(0, prices[0]));
        for (int i = 1; i < prices.length ; i++) {
            int price = prices[i];
            //index의 차이를 계산하는 것이 시간 계산에 좋다.
            while((!stack.isEmpty()) && (stack.peek().cost > price)) {
                Stock item = stack.pop();
                System.out.println(item.index + "," + item.cost);
                answer[item.index] = i - item.index;
            }

            stack.push(new Stock(i, prices[i]));
        }
        //answer 배열의 마지막 인덱스는 무조건 0(다음 시간에 대한 주식 정보가 없기 때문에)
        int lastIndex = stack.pop().index;
        answer[lastIndex] = 0;

        // stack 비우기 & answer 배열에 값 저장
        while(!stack.isEmpty()) {
            Stock item = stack.pop();
            System.out.println(item.index + "," + item.cost);
            answer[item.index] = lastIndex - item.index;
        }
        return answer;
    }

    static class Stock{
        int index;
        int cost;
        Stock(int index, int price){
            this.cost = price;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int [] prices = {1,2,3,2,3};
        int [] solution = solution(prices);
        for(int i=0;i<solution.length;i++){
            System.out.println(solution[i]);
        }
    }
}