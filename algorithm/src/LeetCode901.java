/**
 * @author nakhoonchoi
 * @date 2025/01/17
 * @see https://leetcode.com/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75
 * @mem 55.6MB
 * @time 29ms
 * @caution
 * [고려사항]
 * 스택을 두 개 이용해서 문제를 해결하려고 했으나 시간 초과가 발생했다.
 * 스택에서 관리하는 데이터를 <stock, count>로 관리해서 좌표 압축? 느낌으로 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode 75> 'Online Stock Span'

public class LeetCode901 {
    public Stack<Data> stack;

    public LeetCode901() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().stock <= price){
            span += stack.pop().count;
        }
        stack.push(new Data(price, span));
        return span;
    }

    class Data{
        int stock;
        int count;

        Data(int stock, int count){
            this.stock = stock;
            this.count = count;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */