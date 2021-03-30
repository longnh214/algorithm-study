/**
 * @author choi
 * @date Oct 24, 2020
 * @see https://www.acmicpc.net/problem/1662
 * @mem 12,992kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 스택을 이용해서 해결하는 문제로 반례를 찾기 힘들었던 문제이다.
 * int 값이 범위인 것도 문제였고, 해당 괄호 안의 길이와 괄호 깊이(레벨)를 저장할 클래스가 필요했다.
 * 자료구조(스택) 문제를 많이 풀어봐야겠다는 필요성을 느꼈다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <스택> '압축'
public class BOJ1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Value> valueStack = new Stack<>();
        int answer = 0;
        int level = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) != ')') {
                stack.push(str.charAt(i));
                if(str.charAt(i) == '(') {
                    level++;
                }
            }else {
                int len = 0;
                while(!stack.isEmpty()) {
                    char c = stack.pop();
                    if(c == '(') break;
                    else
                        len++;
                }
                int count = 1;
                if(!stack.isEmpty() && stack.peek() != null) {
                    count = stack.pop() - '0';
                }

                if(valueStack.size() == 0) {
                    valueStack.push(new Value(count * len, level));
                }else {
                    if(valueStack.peek().level == level) {
                        Value tempValue = valueStack.pop();
                        int temp = tempValue.length + (count * len);
                        while(!valueStack.isEmpty()) {
                            if(valueStack.peek().level == level) {
                                temp += valueStack.pop().length;
                            }else {
                                break;
                            }
                        }
                        valueStack.push(new Value(temp, level));
                    }else if(valueStack.peek().level > level){
                        Value tempValue = valueStack.pop();
                        int temp = 0;
                        if(len == 0) {
                            temp = tempValue.length * count;
                        }else {
                            len += tempValue.length;
                            temp = len * count;
                        }
                        while(!valueStack.isEmpty()) {
                            if(valueStack.peek().level == level) {
                                temp += valueStack.pop().length;
                            }else {
                                break;
                            }
                        }
                        valueStack.push(new Value(temp, level));
                    }else {
                        valueStack.push(new Value(count * len, level));
                    }
                }
                level--;
            }
        }

        if(!valueStack.isEmpty()) {
            answer = valueStack.pop().length;
        }
        while(!stack.isEmpty()) {
            char c = stack.pop();
            if(c == '(') continue;
            answer++;
        }
        System.out.println(answer);
    }

    static class Value{
        int length;
        int level;
        Value(int length, int level){
            this.length = length;
            this.level = level;
        }
    }
}