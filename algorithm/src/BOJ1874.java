/**
 * @author nakhoon
 * @date 2022, 4월 1일
 * @see https://www.acmicpc.net/problem/1874
 * @mem 27,924kb
 * @time 312ms
 * @caution
 * [고려사항]
 * 지문을 해석하는 데에 어려웠던 문제이다. 현재 스택에 넣은 값보다 입력 받은 값이 크다면
 * 입력 받은 값까지 스택에 값을 넣고, 그 이후에 스택 맨 위에 있는 값이 value와 같지 않다면
 * NO를 출력해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준 <스택> '스택 수열'
public class BOJ1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int start = 1;
        Stack<Integer> stack = new Stack<>();

        while(N-->0){
            int value = Integer.parseInt(br.readLine());

            while(start <= value){
                stack.push(start++);
                sb.append("+").append("\n");
            }

            if(stack.peek() != value){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}