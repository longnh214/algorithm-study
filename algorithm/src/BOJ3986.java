/**
 * @author nakhoon
 * @date 2022, 5월 21일
 * @see https://www.acmicpc.net/problem/3986
 * @mem 17,500kb
 * @time 240ms
 * @caution
 * [고려사항]
 * 자료구조 중 스택을 이용해서 문제를 해결 할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준 <자료구조> '좋은 단어'
public class BOJ3986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        outer: for(int i=0;i<N;i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                char ch = str.charAt(j);
                if(!stack.isEmpty() && stack.peek() == ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
            if(stack.isEmpty()) answer++;
        }
        System.out.println(answer);
    }
}