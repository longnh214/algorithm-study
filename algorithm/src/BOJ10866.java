/**
 * @author nakhoon
 * @date 2022, 3월 29일
 * @see https://www.acmicpc.net/problem/10866
 * @mem 17,880kb
 * @time 364ms
 * @caution
 * [고려사항]
 * 자바에 내장된 덱 자료구조를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//백준 <덱> '덱'
public class BOJ10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<Integer>();

        for(int i=0;i<N;i++){
            String cmd = br.readLine();
            String [] input = cmd.split(" ");
            int num = -1;
            if(input.length == 2){
                num = Integer.parseInt(input[1]);
            }
            switch(input[0]){
                case "push_front":
                    deque.offerFirst(num);
                    break;
                case "push_back":
                    deque.offerLast(num);
                    break;
                case "pop_front":
                    if(deque.size() != 0){
                        num = deque.pollFirst();
                    }
                    System.out.println(num);
                    break;
                case "pop_back":
                    if(deque.size() != 0){
                        num = deque.pollLast();
                    }
                    System.out.println(num);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if(deque.size() != 0){
                        num = deque.peekFirst();
                    }
                    System.out.println(num);
                    break;
                case "back":
                    if(deque.size() != 0){
                        num = deque.peekLast();
                    }
                    System.out.println(num);
                    break;
            }
        }
    }
}