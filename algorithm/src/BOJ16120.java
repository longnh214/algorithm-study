/**
 * @author nakhoon
 * @date Feb 1, 2022
 * @see https://www.acmicpc.net/problem/16120
 * @mem 24,832kb
 * @time 268ms
 * @caution
 * [고려사항]
 * replace를 통한 방식으로는 시간 초과가 발생했고, P의 개수에 대한 스택을 이용해서 문제를 해결할 수 있었다.(O(N) 방식으로 탐색)
 */
import java.util.*;
import java.io.*;
//백준 <스택> 'PPAP'
public class BOJ16120 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char temp = str.charAt(i);

            if(temp=='P')
                stack.push('P');

            else {
                if(stack.size()>=2 && i<str.length()-1 && str.charAt(i+1)=='P') {
                    stack.pop();
                    stack.pop();
                }
                else {
                    System.out.println("NP");
                    return;
                }
            }
        }
		System.out.println(stack.size() == 1 ? "PPAP" : "NP");
	}
}