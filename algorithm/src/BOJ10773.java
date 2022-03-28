/**
 * @author nakhoon
 * @date 2022, 3월 28일
 * @see https://www.acmicpc.net/problem/10773
 * @mem 21,328kb
 * @time 212ms
 * @caution
 * [고려사항]
 * 스택을 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준 <스택> '제로'
public class BOJ10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }
        int answer = 0;
        while(!stack.isEmpty()){
            answer += (stack.pop());
        }
        System.out.println(answer);
    }
}